package laddergame.domain;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(final String input) {
        validateBlank(input);
        validateLength(input);
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

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Name name)) {
            return false;
        }
        return Objects.equals(getName(), name.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
