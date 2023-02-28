package laddergame.vo;

import java.util.Objects;

public class PlayerName {
    private static final int NAME_LENGTH_LOWER_BOUND_INCLUSIVE = 1;
    private static final int NAME_LENGTH_UPPER_BOUND_INCLUSIVE = 5;
    private static final String RESTRICTED = " ";

    private final String name;

    public PlayerName(String name) {
        validateLengthInRange(name);
        validateHasNoRestricted(name);
        this.name = name;
    }

    private void validateLengthInRange(String name) {
        if (name.length() < NAME_LENGTH_LOWER_BOUND_INCLUSIVE || name.length() > NAME_LENGTH_UPPER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException("플레이어 이름 길이는 1이상 5이하여야합니다.");
        }
    }

    private void validateHasNoRestricted(String name) {
        if (name.contains(RESTRICTED)) {
            throw new IllegalArgumentException("플레이어 이름에는 공백이 포함될 수 없습니다.");
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
        PlayerName p = (PlayerName) o;
        return Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
