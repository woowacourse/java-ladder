package domain;

import java.util.Objects;

public class Width {

    private final int value;

    private Width(final int value) {
        validate(value);
        this.value = value;
    }

    public static Width of(final int value) {
        return new Width(value);
    }

    private void validate(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("너비는 1 이상이어야 합니다.");
        }
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Width)) return false;
        Width width = (Width) o;
        return value == width.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
