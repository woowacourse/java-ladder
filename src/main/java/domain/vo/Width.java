package domain.vo;

import java.util.Objects;

public class Width {

    private static final int MIN_WIDTH = 1;
    private static final int MAX_WIDTH = 99;
    private static final String WIDTH_NOT_IN_RANGE_ERROR_MESSAGE = "사다리 넓이는 " + MIN_WIDTH + "~" + MAX_WIDTH + "사이입니다.";
    private final int value;

    public Width(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int target) {
        if (target < MIN_WIDTH || target > MAX_WIDTH) {
            throw new IllegalArgumentException(WIDTH_NOT_IN_RANGE_ERROR_MESSAGE);
        }
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
        return getValue() == width.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    public int getValue() {
        return value;
    }
}
