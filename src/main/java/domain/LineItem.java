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
                .filter(lineItem -> lineItem.isConnected == isConnected)
                .findAny()
                .orElseThrow()
                .shape;
    }

    public static List<LineItem> getLineItemsAsList() {
        return List.of(LineItem.values());
    }

    public String getShape() {
        return shape;
    }
}
