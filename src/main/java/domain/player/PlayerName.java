package domain.player;

import exception.NameLengthException;
import exception.NullException;

import java.util.EmptyStackException;
import java.util.Objects;

public class PlayerName {
    private final String name;

    private static final int PLAYER_NAME_MAX_SIZE = 5;
    private static final int PLAYER_NAME_MIN_SIZE = 1;

    public PlayerName(String name) {
        checkPlayerName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerName that = (PlayerName) o;

        return Objects.equals(name, that.name);
    }

    private void checkPlayerName(String playerName) {
        checkBlank(playerName);
        checkNull(playerName);
        checkPlayerNameLength(playerName);
    }

    private void checkPlayerNameLength(String playerName) {
        if (playerName.length() > PLAYER_NAME_MAX_SIZE || playerName.length() < PLAYER_NAME_MIN_SIZE) {
            throw new NameLengthException();
        }
    }

    private static void checkBlank(String player) {
        if (player.isBlank()) {
            throw new EmptyStackException();
        }
    }

    private static void checkNull(String player) {
        if (player == null) {
            throw new NullException();
        }
    }
}
