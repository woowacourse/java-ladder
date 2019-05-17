package ladder.validator;

import ladder.constant.MessageConstant;
import ladder.controller.LadderGameController;
import ladder.model.LadderPlayer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LadderPlayerValidator {
    private LadderPlayerValidator() {
    }

    public static void checkAccuracyOfUserInputs(String[] inputs) {
        if (isOnePlayer(inputs)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_LACK_OF_PLAYERS);
        }
        if (isOverlapPlayer(inputs)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_OVERLAP_PLAYERS);
        }
        checkReservedWords(inputs);
    }

    private static boolean isOnePlayer(String[] inputs) {
        return inputs.length == 1;
    }

    private static boolean isOverlapPlayer(String[] inputs) {
        Set<String> checkOverlapNames = new HashSet<>(Arrays.asList(inputs));
        return checkOverlapNames.size() != inputs.length;
    }

    private static void checkReservedWords(String[] inputs) {
        for (String input : inputs) {
            checkReservedWords(input);
        }
    }

    private static void checkReservedWords(String input) {
        if (input.equals(LadderGameController.ALL_RESULTS)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_RESERVED_WORD_ALL);
        }
        if (input.equals(LadderGameController.EXIT_PROGRAM)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_RESERVED_WORD_EXIT);
        }
    }

    public static void checkAccuracyOfName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(MessageConstant.ERROR_NULL);
        }
        name = name.trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException(MessageConstant.ERROR_EMPTY_VALUE);
        }
        if (name.length() > LadderPlayer.MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(MessageConstant.ERROR_EXCESS_PLAYER_NAME_LENGTH);
        }
    }
}
