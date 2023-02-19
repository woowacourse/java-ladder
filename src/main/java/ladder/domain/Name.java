package ladder.domain;

import java.util.Objects;

public class Name {
    private static final int MAXIMUM_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validateBlank(value);
        validateLength(value);
    }

    private void validateBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    private void validateLength(String value) {
        if (value.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
        }
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
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
