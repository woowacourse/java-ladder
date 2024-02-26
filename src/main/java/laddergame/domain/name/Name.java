package laddergame.domain.name;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH = 5;
    private static final String INVALID_NAME = "all";

    private final String name;

    public Name(final String input) {
        validateBlank(input);
        validateLength(input);
        validateInvalidName(input);
        this.name = input;
    }

    private void validateBlank(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름에 빈값을 입력할 수 없습니다.");
        }
    }

    private void validateLength(final String input) {
        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름길이는 5글자를 넘을 수 없습니다.");
        }
    }

    private void validateInvalidName(final String input) {
        if (INVALID_NAME.equals(input)) {
            throw new IllegalArgumentException("[ERROR] 이름을 " + INVALID_NAME + "로 지을 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Name other)) {
            return false;
        }
        return Objects.equals(getName(), other.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
