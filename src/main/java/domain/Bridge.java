package domain;

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
               .orElseThrow();
    }

    public String getShape() {
        return shape;
    }
}
