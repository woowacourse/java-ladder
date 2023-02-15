package ladder;

import java.util.Arrays;

public enum Bar {
    MOVABLE(true),
    IMMOVABLE(false);

    private final boolean isMovable;

    Bar(boolean isMovable) {
        this.isMovable = isMovable;
    }

    public static Bar of(boolean isMovable) {
        return Arrays.stream(Bar.values())
                .filter(bar -> bar.isMovable == isMovable)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isMovable() {
        return this.isMovable;
    }
}
