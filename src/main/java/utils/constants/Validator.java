package utils.constants;

import static utils.constants.ErrorMessages.DUPLICATED_INPUT;
import static utils.constants.ErrorMessages.NAME_LENGTH;
import static utils.constants.ErrorMessages.NUMBER_FORMAT;
import static utils.constants.GameRules.MAX_LADDER_HEIGHT;
import static utils.constants.GameRules.MAX_NAME_LENGTH;
import static utils.constants.GameRules.MIN_LADDER_HEIGHT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static void validateDuplication(List<String> inputs) {
        Set<String> inputsWithoutDuplication = new HashSet<>(inputs);
        if (inputs.size() != inputsWithoutDuplication.size()) {
            throw new IllegalArgumentException(DUPLICATED_INPUT.getMessage());
        }
    }
}
