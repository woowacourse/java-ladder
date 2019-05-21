package ladder.domain;

import ladder.util.CustomStringUtils;

import java.util.Objects;

public class PlayerName {
    private static final int MAX_PLAYER_NAME_LENGTH = 5;
    private static final String VIOLATE_PLAYER_NAMES = "참가자 이름을 5글자 이내로 입력해주세요.";

    private final String name;

    public PlayerName(String name) {
        checkNameLength(name);
        this.name = name;
    }

    public static void checkNameLength(String name) {
        CustomStringUtils.checkIsBlank(name);

        if (name.length() > MAX_PLAYER_NAME_LENGTH) {
            throw new IllegalArgumentException(VIOLATE_PLAYER_NAMES);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
