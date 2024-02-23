package view;

import java.util.Arrays;
import java.util.List;

public enum LadderItem {

    CONNECTED(true, "-----|"),
    UNCONNECTED(false, "     |");

    private final boolean isConnected;
    private final String shape;

    LadderItem(boolean isConnected, String shape) {
        this.isConnected = isConnected;
        this.shape = shape;
    }

    public static String getShapeByIsConnected(boolean isConnected) {
        return Arrays.stream(LadderItem.values())
                .filter(ladderItem -> ladderItem.isConnected == isConnected)
                .findAny()
                .orElseThrow()
                .shape;
    }

    public static List<LadderItem> getLadderItemsAsList() {
        return Arrays.stream(LadderItem.values()).toList();
    }

    public String getShape() {
        return shape;
    }
}
