package model;

import java.util.Objects;

public class Result {

    private final String value;

    public Result(String value) {
        if (value.isBlank() || value.isEmpty()) {
            throw new IllegalArgumentException("실행 결과가 빈 문자열이나 공백이 될 수 없습니다.");
        }
        this.value = value;
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
        return Objects.equals(getValue(), result.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
