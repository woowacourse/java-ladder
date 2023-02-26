package domain.vo;

import java.util.Objects;

public class Height {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 5_000;
    private static final String HEIGHT_NOT_IN_RANGE_ERROR_MESSAGE =
        "높이는 " + MIN_HEIGHT + "~" + MAX_HEIGHT + " 사이의 숫자만 가능합니다.";

    private final int value;

    public Height(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int target) {
        if (target < MIN_HEIGHT || target > MAX_HEIGHT) {
            throw new IllegalArgumentException(HEIGHT_NOT_IN_RANGE_ERROR_MESSAGE);
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
        final Height height = (Height) o;
        return getValue() == height.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    public int getValue() {
        return value;
    }
}
