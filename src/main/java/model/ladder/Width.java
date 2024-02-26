package model.ladder;

import java.util.Objects;

public class Width {
    private final int value;

    public Width(final int value) {
        this.value = value;
    }

    public static Width from(final int players) {
        return new Width(players - 1);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Width width = (Width) o;
        return value == width.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int size() {
        return value;
    }
}
