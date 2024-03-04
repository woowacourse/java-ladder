package model;

import java.util.Objects;

public class Result {

    private final Position position;
    private final String value;

    public Result(Position position, String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("결과가 공백이나 빈 문자열이면 안됩니다.");
        }
        this.position = position;
        this.value = value;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public String getValue() {
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
        Result result = (Result) o;
        return Objects.equals(position, result.position)
                && Objects.equals(getValue(), result.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, getValue());
    }
}
