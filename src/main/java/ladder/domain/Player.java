package ladder.domain;

import java.util.Objects;

public class Player {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNotEmpty(name);
        validateMaxLength(name);
        validateNotAll(name);
    }

    private void validateNotEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름이 1글자 미만입니다.");
        }
    }

    private void validateMaxLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름이 5글자 초과입니다.");
        }
    }

    private void validateNotAll(String name) {
        if (name.equals("all")) {
            throw new IllegalArgumentException("이름으로 'all'은 사용할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
