package domain.ladder;

import java.util.Objects;

public class Height {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private final int value;

    public Height(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int height) {
        if (height < MIN_RANGE || height > MAX_RANGE) {
            throw new IllegalArgumentException("1 이상 100 이하의 자연수만 입력해 주세요.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Height height1 = (Height) o;
        return value == height1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
