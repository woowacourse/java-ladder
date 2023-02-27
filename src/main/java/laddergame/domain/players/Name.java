package laddergame.domain.players;

import java.util.Objects;
import laddergame.util.ExceptionMessageFormatter;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String name) {
        validateNullOrEmpty(name);
        validateLength(name);
    }

    private static void validateLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            final String message = String.format("참여자의 이름은 최대 %d글자를 넘을 수 없습니다.", MAX_NAME_LENGTH);
            throw new IllegalArgumentException(ExceptionMessageFormatter.format(message, name.length()));
        }
    }

    private static void validateNullOrEmpty(final String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("참여자의 이름은 null 또는 빈 문자열일 수 없습니다.");
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
