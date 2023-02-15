package domain;

import java.util.ArrayList;
import java.util.List;

public enum BlockType {
    CROSS("-----", true),
    NOT_CROSS("     ", false);

    private final String type;
    private final boolean isCross;

    private BlockType(String type, boolean isCross) {
        this.type = type;
        this.isCross = isCross;
    }

    public static List<String> getBlockTypes(Line line) {
        List<Boolean> blockLine = line.getLine();
        List<String> blockTypes = new ArrayList<>();

        for (Boolean block : blockLine) {
            decideBlockType(blockTypes, block);
        }
        return blockTypes;
    }

    private static void decideBlockType(List<String> blockTypes, boolean block) {
        if (block == CROSS.isCross) {
            blockTypes.add(CROSS.type);
        }

        if (block == NOT_CROSS.isCross) {
            blockTypes.add(NOT_CROSS.type);
        }
    }
}
