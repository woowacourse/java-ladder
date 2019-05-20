package ladder.domain.ladder;

import java.util.Objects;

public class Height {
    private final int number;

    public Height(int number) {
        checkNegative(number);
        this.number = number;
    }

    private void checkNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("자연수만 입력 가능합니다.");
        }
    }

    public int getHeight() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height positive = (Height) o;
        return number == positive.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
