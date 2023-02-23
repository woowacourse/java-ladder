package ladder.domain.player;

import ladder.domain.player.exception.ForbiddenPlayerNameException;
import ladder.domain.player.exception.PlayerNameLengthException;

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
}
