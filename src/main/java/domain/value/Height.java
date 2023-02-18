package domain.value;

import java.util.Objects;

public class Height {

    private final int value;

    private Height(final int value) {
        validate(value);
        this.value = value;
    }

    public static Height of(final int value) {
        return new Height(value);
    }

    private void validate(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("높이는 1 이상이어야 합니다.");
        }
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Height)) return false;
        Height height = (Height) o;
        return value == height.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
