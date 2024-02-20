package laddergame;

import java.util.Objects;

public class Name {
    private final String value;

    public Name(final String value) {
        validateBlank(value);
        validateLength(value);
        this.value = value;
    }

    private void validateBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름에 빈값을 입력할 수 없습니다.");
        }
    }

    private void validateLength(final String value) {
        if (value.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름길이는 5글자를 넘을 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Name name)) {
            return false;
        }
        return Objects.equals(getValue(), name.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
