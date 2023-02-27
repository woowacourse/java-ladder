package domain.validator;

import static domain.ErrorMessages.CONFLICT_NAME;
import static domain.ErrorMessages.DIFFERENT_LENGTH;
import static domain.ErrorMessages.DUPLICATED_INPUT;
import static domain.ErrorMessages.NAME_LENGTH;
import static domain.ErrorMessages.NUMBER_FORMAT;
import static domain.ErrorMessages.REWARD_LENGTH;
import static domain.GameRules.MAX_LADDER_HEIGHT;
import static domain.GameRules.MAX_NAME_LENGTH;
import static domain.GameRules.MIN_LADDER_HEIGHT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.ResultCommands;

public class Validator {

    public static void validateName(String name) {
        validateNameLength(name);
        validateNameConflictWithCommand(name);
    }

    private static void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(NAME_LENGTH.getMessage());
        }
    }

    private static void validateNameConflictWithCommand(String name) {
        if (ResultCommands.isQuit(name) || ResultCommands.isAll(name)) {
            throw new IllegalArgumentException(CONFLICT_NAME.getMessage());
        }
    }


    public static void validateReward(String reward) {
        if (reward.isEmpty() || reward.length() > MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(REWARD_LENGTH.getMessage());
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

    public static void validateSameLength(List<String> rewards, int userCount) {
        if (rewards.size() != userCount) {
            String message = String.format(DIFFERENT_LENGTH.getMessage(), userCount);
            throw new IllegalArgumentException(message);
        }
    }
}
