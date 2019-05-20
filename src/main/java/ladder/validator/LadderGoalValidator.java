package ladder.validator;

import ladder.constant.MessageConstant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LadderGoalValidator {
    private LadderGoalValidator() {
    }

    public static void checkAccuracyOfUserInputs(String[] inputs, int numOfPlayers) {
        if (!isMatchPlayersAndGoals(inputs, numOfPlayers)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_MISMATCH_NUM_OF_PLAYERS_AND_GOALS);
        }
        if (isOverlapLadderGoal(inputs)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_OVERLAP_GOALS);
        }
    }

    private static boolean isMatchPlayersAndGoals(String[] inputs, int numOfPlayers) {
        return inputs.length == numOfPlayers;
    }

    private static boolean isOverlapLadderGoal(String[] inputs) {
        Set<String> checkOverlapGoalNames = new HashSet<>(Arrays.asList(inputs));
        return checkOverlapGoalNames.size() != inputs.length;
    }
}
