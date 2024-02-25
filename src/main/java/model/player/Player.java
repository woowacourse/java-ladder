package model.player;

import java.util.Objects;

public class Player {
    public static final int MAX_LENGTH_OF_NAME = 5;
    private static final String INVALID_LENGTH_OF_NAME = "참여자 이름은 최대 5글지입니다.";

    private final String name;


    public Player(String name) {
        validateLengthOfName(name);
        this.name = name;
    }

    private void validateLengthOfName(String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(INVALID_LENGTH_OF_NAME);
        }
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
