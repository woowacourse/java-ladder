package ladder.domain.player;

import java.util.regex.Pattern;
import ladder.exception.ErrorMessage;
import ladder.exception.InvalidInputException;

public class Player {
    public static final int MAXIMUM_NAME_RANGE = 5;
    private static final Pattern NAME_VALID_FORMAT = Pattern.compile("[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]+");
    private final String name;

    public Player(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        validateRange(name);
        validateFormat(name);
    }

    private void validateFormat(final String name) {
        if (isInvalidFormat(name)) {
            throw new InvalidInputException(ErrorMessage.INVALID_PLAYER_NAME_FORMAT);
        }
    }

    private void validateRange(final String name) {
        if (name.isBlank() || name.length() > MAXIMUM_NAME_RANGE) {
            throw new InvalidInputException(ErrorMessage.INVALID_PLAYER_NAME_RANGE);
        }
    }

    private boolean isInvalidFormat(final String name) {
        return !NAME_VALID_FORMAT.matcher(name)
                .matches();
    }

    public String getName() {
        return name;
    }
}
