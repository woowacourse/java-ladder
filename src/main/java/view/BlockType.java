package view;

import domain.Line;
import java.util.List;
import java.util.stream.Collectors;

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

        return blockLine.stream()
                .map(BlockType::decideBlockType)
                .collect(Collectors.toList());
    }

    private static String decideBlockType(boolean block) {
        if (block == CROSS.isCross) {
            return CROSS.type;
        }
        return NOT_CROSS.type;
    }
}
