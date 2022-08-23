package dev.quintindunn.printit.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.quintindunn.printit.PrintIt;
import dev.quintindunn.printit.util.Block;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.*;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ToStl {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("ToSTL")
                .then(argument("x1", IntegerArgumentType.integer())
                .then(argument("y1", IntegerArgumentType.integer())
                .then(argument("z1", IntegerArgumentType.integer())
                .then(argument("x2", IntegerArgumentType.integer())
                .then(argument("y2", IntegerArgumentType.integer())
                .then(argument("z2", IntegerArgumentType.integer())
                .executes(ToStl::run))))))));
    }

    private static int run(CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(Text.literal("Running!"), false);


        final int x1 = IntegerArgumentType.getInteger(context, "x1");
        final int y1 = IntegerArgumentType.getInteger(context, "y1");
        final int z1 = IntegerArgumentType.getInteger(context, "z1");

        final int x2 = IntegerArgumentType.getInteger(context, "x2");
        final int y2 = IntegerArgumentType.getInteger(context, "y2");
        final int z2 = IntegerArgumentType.getInteger(context, "z2");

        // Loop through all the blocks in the area accounting for negative values

        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);
        int minZ = Math.min(z1, z2);
        int maxZ = Math.max(z1, z2);


        int volume = 0;

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    volume++;
                }
            }
        }
        Block[] blocks = new Block[volume];

        PrintIt.LOGGER.info(String.valueOf(volume));

        StringBuilder content = new StringBuilder();

        content.append("solid main\n");

        int count = 0;
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    count++;
                    BlockPos pos = new BlockPos(x, y, z);
                    World world = context.getSource().getWorld();
                    assert World.isValid(pos);
                    if (!world.isAir(pos) && !world.getBlockState(pos).isTranslucent(world, pos))
                    {
                        content.append(new Block(x, z, y, Integer.toString(count)).get_block_stl());
                    }

                }
            }
        }
        content.append("endsolid main");
        PrintIt.LOGGER.info("toString");
        String stl = content.toString();

        PrintIt.LOGGER.info("Writing");

        try {
            // Open STL file
            java.io.PrintWriter writer = new java.io.PrintWriter("C:\\Users\\T1ps\\Desktop\\printit.stl", StandardCharsets.UTF_8);
            // Write the STL file
            writer.println(stl);
            // Close the file
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




        context.getSource().sendFeedback(Text.literal("Done, wrote, " + count + " blocks."), false);
        return 0;
    }
}