package domain;

import util.ExceptionMessages;

import java.util.Arrays;

public enum Bridge {

    BRIDGE("-----", true),
    NO_BRIDGE("     ", false);

    private final String shape;
    private final boolean exist;

    Bridge(final String shape, final boolean exist) {
        this.shape = shape;
        this.exist = exist;
    }

    public static Bridge getBy(final boolean exist) {
        return Arrays.stream(values())
                .filter(value -> value.exist == exist)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessages.NO_ENUM));
    }

    public String getShape() {
        return shape;
    }
}
