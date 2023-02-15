package utils.constants;

import static utils.constants.ErrorMessages.*;
import static utils.constants.GameRules.*;

public class Validator {

    public static void validateName(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(NAME_LENGTH.getMessage());
        }
    }

    public static void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT.getValue()
                || ladderHeight > MAX_LADDER_HEIGHT.getValue()) {
            throw new IllegalArgumentException(NUMBER_FORMAT.getMessage());
        }
    }
}
