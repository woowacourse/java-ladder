package domain;

import java.util.Arrays;

public enum LadderItem {

    TRUE_LINE(true, "-----|"),
    FALSE_LINE(false, "     |");

    private final Boolean isConnected;
    private final String shape;

    LadderItem(Boolean isConnected, String shape) {
        this.isConnected = isConnected;
        this.shape = shape;
    }

    public static String getShapeByIsConnected(Boolean isConnected) {
        return Arrays.stream(LadderItem.values())
                .filter(ladderItem -> ladderItem.isConnected == isConnected)
                .findAny()
                .orElseThrow()
                .shape;
    }
}
