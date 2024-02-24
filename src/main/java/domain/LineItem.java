package domain;

import java.util.Arrays;

public enum LineItem {

    CONNECTED(true, "-----|"),
    UNCONNECTED(false, "     |");

    private final boolean isConnected;
    private final String shape;

    LineItem(boolean isConnected, String shape) {
        this.isConnected = isConnected;
        this.shape = shape;
    }

    public static LineItem valueOf(boolean isConnected) {
        return Arrays.stream(LineItem.values())
                .filter(lineItem -> lineItem.isConnected == isConnected)
                .findAny()
                .orElseThrow();
    }

    public static boolean isUnconnected(LineItem lineItem) {
        return lineItem.equals(LineItem.UNCONNECTED);
    }

    public String getShape() {
        return shape;
    }
}
