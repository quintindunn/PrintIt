package dev.quintindunn.printit;

import dev.quintindunn.printit.commands.ToPythonList;
import dev.quintindunn.printit.commands.ToStl;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.server.command.CommandManager.*;

public class PrintIt implements ModInitializer {
    // Logger
    public static final Logger LOGGER = LoggerFactory.getLogger("printit");

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
                ToStl.register(dispatcher)
        );
//        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
//                ToPythonList.register(dispatcher)
//        );
    }
}
