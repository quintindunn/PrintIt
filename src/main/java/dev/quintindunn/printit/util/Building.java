package dev.quintindunn.printit.util;

import dev.quintindunn.printit.PrintIt;

public class Building {
    Block[] blocks;

    public Building(Block[] blocks) {
        this.blocks = blocks;
    }

    public String generate_stl() {
        StringBuilder result = new StringBuilder();
        for (Block block : blocks) {
            PrintIt.LOGGER.info(block.x + " " + block.y + " " + block.z);
            result.append(block.get_block_stl()).append("\n");
        }
        return result.toString();
    }
}
