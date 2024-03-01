package laddergame.domain.player;

import laddergame.util.InputValidator;

import java.util.Objects;

public class Player {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public Player(final String input) {
        InputValidator.validateBlank(input);
        validateLength(input);
        validateFunctionName(input);
        this.name = input;
    }

    public String getName() {
        return name;
    }

    private void validateLength(final String input) {
        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름길이는 5글자를 넘을 수 없습니다.");
        }
    }

    private void validateFunctionName(final String input) {
        if (input.equals("all")) {
            throw new IllegalArgumentException("[ERROR] 이름에 all을 입력할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Player other)) {
            return false;
        }
        return Objects.equals(getName(), other.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
