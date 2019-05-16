package calculator;

import java.util.Objects;

public class Positive {
    private static final int POSITIVE_BOUNDARY = 0;

    private int number;

    Positive(int number) {
        validatePositive(number);
        this.number = number;
    }

    void validatePositive(int number) {
        if (number < POSITIVE_BOUNDARY)
            throw new IllegalArgumentException();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positive that = (Positive) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
