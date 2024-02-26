package domain;


import java.util.Arrays;

public enum Bridge {

    BRIDGE(true),
    NO_BRIDGE(false);

    public static final String NO_ENUM = "Bridge를 찾을 수 없습니다.";
    private final boolean exist;

    Bridge(final boolean exist) {
        this.exist = exist;
    }

    public static Bridge from(final boolean exist) {
        return Arrays.stream(values())
                .filter(value -> value.exist == exist)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NO_ENUM));
    }

    public boolean exists() {
        return this.exist;
    }

}
