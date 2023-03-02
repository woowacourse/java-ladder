package ladder.domain.player;

import ladder.domain.player.exception.ForbiddenPlayerNameException;
import ladder.domain.player.exception.PlayerNameLengthException;

import java.util.Objects;

public class PlayerName {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String FORBIDDEN_NAME = "all";

    private final String name;

    public PlayerName(final String name) {
        validatePlayerName(name);
        validateForbiddenName(name);
        this.name = name;
    }

    private void validatePlayerName(final String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new PlayerNameLengthException();
        }
    }

    private void validateForbiddenName(final String name) {
        if (name.equals(FORBIDDEN_NAME)) {
            throw new ForbiddenPlayerNameException();
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
        PlayerName p = (PlayerName) o;
        return Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
