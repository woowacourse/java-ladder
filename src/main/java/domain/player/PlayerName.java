package domain.player;

import java.util.Objects;

public class PlayerName {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String SPECIAL_NAME_ALL = "all";

    private final String name;

    public PlayerName(String name) {
        validateLength(name);
        this.name = name;
    }

    public boolean isNotSpecialKeyWord() {
        return !name.equals(SPECIAL_NAME_ALL);
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
        PlayerName playerName1 = (PlayerName) o;
        return Objects.equals(name, playerName1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private void validateLength(String name) {
        if (isInvalidLengthName(name)) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 " + MIN_LENGTH + "자에서 " + MAX_LENGTH + "자 사이여야 합니다");
        }
    }

    private boolean isInvalidLengthName(String name) {
        return name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
    }
}
