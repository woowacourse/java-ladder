package ladder.domain.player;

import java.util.regex.Pattern;
import ladder.exception.ErrorMessage;
import ladder.exception.InvalidInputException;

public class Player {
    public static final int MAXIMUM_NAME_RANGE = 5;
    private static final Pattern NAME_VALID_FORMAT = Pattern.compile("[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]+");
    private final String name;

    public Player(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validateNameRange(name);
        validateNameFormat(name);
    }

    private void validateNameRange(final String name) {
        if (name.isBlank() || name.length() > MAXIMUM_NAME_RANGE) {
            throw new InvalidInputException(ErrorMessage.INVALID_PLAYER_NAME_RANGE);
        }
    }

    private void validateNameFormat(final String name) {
        if (!NAME_VALID_FORMAT.matcher(name).matches()) {
            throw new InvalidInputException(ErrorMessage.INVALID_PLAYER_NAME_FORMAT);
        }
    }

    public String getName() {
        return name;
    }
}
