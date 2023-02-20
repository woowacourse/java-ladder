package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum LineType {
    GO(Boolean.TRUE, "-----"),
    STOP(Boolean.FALSE, "     ");

    private static final Map<Boolean, LineType> MAP = new HashMap<>();

    static {
        for (LineType type : values()) {
            MAP.put(type.movable, type);
        }
    }

    private final Boolean movable;
    private final String message;

    LineType(Boolean movable, String message) {
        this.movable = movable;
        this.message = message;
    }

    public static String getMessageByMovable(Boolean movable) {
        Objects.requireNonNull(movable);
        return MAP.get(movable)
            .message;
    }
}
