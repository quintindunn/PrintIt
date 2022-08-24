package dev.quintindunn.printit.util;

public class Block {
    public final int x, y, z;
    public String identifier;

    public Block(int x, int y, int z, String identifier)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.identifier = identifier;
    }
    public String get_block_stl() {
        String content = "";

        // First triangle

//        0.0   0.0   0.0
//        1.0   1.0   0.0
//        1.0   0.0   0.0
        content += String.format("facet normal %s %s %s\n", 0.0+this.x, 1.0+this.y, -1.0+this.z);
        content += "outer loop\n";
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 0.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 1.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 0.0+this.y, 0.0+this.z);
        content += "endloop\n";
        content += "endfacet\n";

        // Second triangle

//        0.0   0.0   0.0
//        0.0   1.0   0.0
//        1.0   1.0   0.0
        content += String.format("facet normal %s %s %s\n", 0.0+this.x, 0.0+this.y, -1.0+this.z);
        content += "outer loop\n";
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 0.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 1.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 1.0+this.y, 0.0+this.z);
        content += "endloop\n";
        content += "endfacet\n";

        // Third triangle

//        0.0   0.0   0.0
//        0.0   1.0   1.0
//        0.0   1.0   0.0
        content += String.format("facet normal %s %s %s\n", -1.0+this.x, 0.0+this.y, -0.0+this.z);
        content += "outer loop\n";
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 0.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 1.0+this.y, 1.0+this.z);
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 1.0+this.y, 0.0+this.z);
        content += "endloop\n";
        content += "endfacet\n";

        // Fourth triangle

//        0.0   0.0   0.0
//        0.0   0.0   1.0
//        0.0   1.0   1.0
        content += String.format("facet normal %s %s %s\n", -1.0+this.x, 0.0+this.y, 0.0+this.z);
        content += "outer loop\n";
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 0.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 0.0+this.y, 1.0+this.z);
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 1.0+this.y, 1.0+this.z);
        content += "endloop\n";
        content += "endfacet\n";

        // Fifth triangle

//        0.0   1.0   0.0
//        1.0   1.0   1.0
//        1.0   1.0   0.0
        content += String.format("facet normal %s %s %s\n", 0.0+this.x, 1.0+this.y, 0.0+this.z);
        content += "outer loop\n";
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 1.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 1.0+this.y, 1.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 1.0+this.y, 0.0+this.z);
        content += "endloop\n";
        content += "endfacet\n";

        // Sixth triangle

//        0.0   1.0   0.0
//        0.0   1.0   1.0
//        1.0   1.0   1.0
        content += String.format("facet normal %s %s %s\n", 0.0+this.x, 1.0+this.y, 0.0+this.z);
        content += "outer loop\n";
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 1.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 1.0+this.y, 1.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 1.0+this.y, 1.0+this.z);
        content += "endloop\n";
        content += "endfacet\n";

        // Seventh triangle

//        1.0   0.0   0.0
//        1.0   1.0   0.0
//        1.0   1.0   1.0
        content += String.format("facet normal %s %s %s\n", 1.0+this.x, 0.0+this.y, 0.0+this.z);
        content += "outer loop\n";
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 0.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 1.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 1.0+this.y, 1.0+this.z);
        content += "endloop\n";
        content += "endfacet\n";

        // Eighth triangle

//        1.0   0.0   0.0
//        1.0   1.0   1.0
//        1.0   0.0   1.0
        content += String.format("facet normal %s %s %s\n", 1.0+this.x, 0.0+this.y, 0.0+this.z);
        content += "outer loop\n";
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 0.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 1.0+this.y, 1.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 0.0+this.y, 1.0+this.z);
        content += "endloop\n";
        content += "endfacet\n";

        // Ninth triangle

//        0.0   0.0   0.0
//        1.0   0.0   0.0
//        1.0   0.0   1.0
        content += String.format("facet normal %s %s %s\n", 0.0+this.x, -1.0+this.y, 0.0+this.z);
        content += "outer loop\n";
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 0.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 0.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 0.0+this.y, 1.0+this.z);
        content += "endloop\n";
        content += "endfacet\n";

        // Tenth triangle

//        0.0   0.0   0.0
//        1.0   0.0   1.0
//        0.0   0.0   1.0
        content += String.format("facet normal %s %s %s\n", 0.0+this.x, -1.0+this.y, 0.0+this.z);
        content += "outer loop\n";
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 0.0+this.y, 0.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 0.0+this.y, 1.0+this.z);
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 0.0+this.y, 1.0+this.z);
        content += "endloop\n";
        content += "endfacet\n";

        // Eleventh triangle

//        0.0   0.0   1.0
//        1.0   0.0   1.0
//        1.0   1.0   1.0
        content += String.format("facet normal %s %s %s\n", 0.0+this.x, 0.0+this.y, 1.0+this.z);
        content += "outer loop\n";
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 0.0+this.y, 1.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 0.0+this.y, 1.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 1.0+this.y, 1.0+this.z);
        content += "endloop\n";
        content += "endfacet\n";

        // Twelfth triangle


        content += String.format("facet normal %s %s %s\n", 0.0+this.x, 0.0+this.y, 1.0+this.z);
        content += "outer loop\n";
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 0.0+this.y, 1.0+this.z);
        content += String.format("vertex %s %s %s\n", 1.0+this.x, 1.0+this.y, 1.0+this.z);
        content += String.format("vertex %s %s %s\n", 0.0+this.x, 1.0+this.y, 1.0+this.z);
        content += "endloop\n";
        content += "endfacet\n";

        return content;
    }
}
