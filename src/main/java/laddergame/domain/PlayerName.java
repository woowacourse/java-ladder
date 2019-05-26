package laddergame.domain;

import java.util.Objects;

public class PlayerName {
    private final static int MAX_PLAYER_NAME_LENGTH = 5;

    private final String name;

    public PlayerName(final String name) {
        checkNullName(name);
        checkNameLength(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static void checkNullName(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("입력하신 이름이 null입니다.\n다시 입력해주세요.");
        }
    }

    private static void checkNameLength(String input) {
        if (input.isEmpty() || input.length() > MAX_PLAYER_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이가 적합하지 않습니다.\n다시 입력해주세요.");
        }
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
