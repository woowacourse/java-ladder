package view;

import domain.Line;
import java.util.List;
import java.util.stream.Collectors;

public enum BlockType {
    CROSS("-", true),
    NOT_CROSS(" ", false);

    final String type;
    final boolean isCross;

    BlockType(String type, boolean isCross) {
        this.type = type;
        this.isCross = isCross;
    }

    public static List<BlockType> getBlockTypes(Line line) {
        List<Boolean> blockLine = line.getLine();

        return blockLine.stream()
            .map(BlockType::decideBlockType)
            .collect(Collectors.toList());
    }

    private static BlockType decideBlockType(boolean block) {
        if (block == CROSS.isCross) {
            return CROSS;
        }
        return NOT_CROSS;
    }

    public String getType() {
        return type;
    }
}
