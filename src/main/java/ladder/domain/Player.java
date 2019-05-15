package ladder.domain;

import java.util.Objects;

public final class Player {
    private static final int NAME_LENGTH_CONDITION = 5;

    private final String name;

    public Player(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 1글자 이상 입력해주세요.");
        }
        if (name.length() > NAME_LENGTH_CONDITION) {
            throw new IllegalArgumentException("이름은 " + NAME_LENGTH_CONDITION + "글자 이하로 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
