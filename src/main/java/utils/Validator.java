package utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.constants.ErrorMessages.*;
import static utils.constants.GameRules.*;

public class Validator {

    public static void validateName(final String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(NAME_LENGTH.getMessage());
        }
    }

    public static void validateLadderHeight(final int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT.getValue()
                || ladderHeight > MAX_LADDER_HEIGHT.getValue()) {
            throw new IllegalArgumentException(NUMBER_FORMAT.getMessage());
        }
    }

    public static void validateDuplication(final List<String> inputs) {
        Set<String> inputsWithoutDuplication = new HashSet<>(inputs);
        if (inputs.size() != inputsWithoutDuplication.size()) {
            throw new IllegalArgumentException(DUPLICATED_INPUT.getMessage());
        }
    }
}
