package domain;

import java.util.Arrays;

public enum LadderItem {

    CONNECTED(true),
    UNCONNECTED(false);

    private final boolean isConnected;

    LadderItem(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static LadderItem getLadderItemByIsConnected(boolean isConnected) {
        return Arrays.stream(LadderItem.values())
                .filter(item -> item.isConnected == isConnected)
                .findAny()
                .orElseThrow();
    }
}
