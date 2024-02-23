package domain;

import java.util.Arrays;

public enum LadderItem {

    CONNECTED(true, "-----|"),
    UNCONNECTED(false, "     |");

    private final boolean isConnected;
    private final String shape;

    LadderItem(boolean isConnected, String shape) {
        this.isConnected = isConnected;
        this.shape = shape;
    }

    public static LadderItem getLadderItemByIsConnected(boolean isConnected) {
        return Arrays.stream(LadderItem.values())
                .filter(item -> item.isConnected == isConnected)
                .findAny()
                .orElseThrow();
    }

    public String getShape() {
        return shape;
    }
}
