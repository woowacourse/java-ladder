package domain.ladder.attribute;

import java.util.Objects;

public class Height {

    private final int height;

    public Height(String inputNumber) {
        validate(inputNumber);
        this.height = Integer.parseInt(inputNumber);
    }

    private void validate(String inputNumber) {
        validateIsNumeric(inputNumber);
        validateSize(inputNumber);
    }

    private void validateIsNumeric(String inputNumber) {
        if (!inputNumber.matches("\\d+")) {
            throw new IllegalArgumentException("높이는 숫자만 입력 가능합니다.");
        }
    }

    private void validateSize(String inputNumber) {
        if (Integer.valueOf(inputNumber) <= 0) {
            throw new IllegalArgumentException("높이는 1 이상이여야 합니다.");
        }
    }

    public int heightToInt() {
        return height;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (!(object instanceof final Height height1)) return false;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

}
