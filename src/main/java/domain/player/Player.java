package domain.player;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    public static final String ALL_PLAYER_COMMAND = "all";

    private final String name;

    public Player(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if ((name.isBlank() || name.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException("참가자 이름은 1~%d자 이내로 입력해야합니다.".formatted(MAX_NAME_LENGTH));
        }
        if (name.equalsIgnoreCase(ALL_PLAYER_COMMAND)) {
            throw new IllegalArgumentException("참가자 이름에 all을 입력할 수 없습니다.");
        }
    }

    public boolean isSameName(final String otherName) {
        return this.name.equals(otherName);
    }

    public String getName() {
        return name;
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
}
