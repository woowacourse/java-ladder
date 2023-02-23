package domain.vo;

import java.util.Objects;

public class Result {

    public static final String LENGTH_ERROR_MESSAGE = "결과의 길이는 %s ~ %s 글자입니다.";
    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;
    private final String value;

    public Result(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                String.format(LENGTH_ERROR_MESSAGE, MIN_LENGTH, MAX_LENGTH));
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
        Result result = (Result) o;
        return Objects.equals(value, result.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String getValue() {
        return value;
    }
}
