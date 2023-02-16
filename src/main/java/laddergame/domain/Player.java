package laddergame.domain;

import laddergame.constant.ErrorMessage;

public class Player {

    private final String name;

    public Player(String name) {
        validatePlayerName(name);
        this.name = name;
    }

    private void validatePlayerName(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_PLAYER_NAME.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Player) {
            return name.equals(((Player) obj).getName());
        }
        return false;
    }
}
