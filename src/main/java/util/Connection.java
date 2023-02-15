package util;

import java.util.Arrays;

public enum Connection {
    DISCONNECT_BRIDGE(0,false),
    CONNECT_BRIDGE(1,true);

    private final int value;
    private final boolean status;

    Connection(int value, boolean status){
        this.value = value;
        this.status = status;
    }

    public static Connection valueOf(int statusValue) {
        return Arrays.stream(values())
                .filter(status -> status.getValue() == statusValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않은 status 입니다."));
    }

    public int getValue() {
        return value;
    }

    public boolean getStatus() {
        return status;
    }

}
