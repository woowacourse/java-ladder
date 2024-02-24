package domain;

import java.util.Arrays;
import java.util.List;

public enum LineItem {

    CONNECTED(true, "-----|"),
    UNCONNECTED(false, "     |");

    private final boolean isConnected;
    private final String shape;

    LineItem(boolean isConnected, String shape) {
        this.isConnected = isConnected;
        this.shape = shape;
    }

    public static String getShapeByIsConnected(boolean isConnected) {
        return Arrays.stream(LineItem.values())
                .filter(ladderItem -> ladderItem.isConnected == isConnected)
                .findAny()
                .orElseThrow()
                .shape;
    }

    public static List<LineItem> getLadderItemsAsList() {
        return Arrays.stream(LineItem.values()).toList();
    }

    public String getShape() {
        return shape;
    }
}
