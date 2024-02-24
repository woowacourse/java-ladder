package domain;

import util.ExceptionMessages;

import java.util.Arrays;

public enum Bridge {

    BRIDGE(true),
    NO_BRIDGE(false);

    private final boolean exist;

    Bridge(final boolean exist) {
        this.exist = exist;
    }

    public static Bridge from(final boolean exist) {
        return Arrays.stream(values())
                .filter(value -> value.exist == exist)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessages.NO_ENUM));
    }

    public boolean exists(){
        return this.exist;
    }

}
