package ladder.validator;

import ladder.constant.MessageConstant;
import ladder.model.LadderGoal;

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

    public static void checkAccuracyOfGoalName(String goalName) {
        if (goalName == null) {
            throw new IllegalArgumentException(MessageConstant.ERROR_NULL);
        }
        goalName = goalName.trim();
        if (goalName.isEmpty()) {
            throw new IllegalArgumentException(MessageConstant.ERROR_EMPTY_VALUE);
        }
        if (goalName.length() > LadderGoal.MAX_LENGTH_OF_GOAL_NAME) {
            throw new IllegalArgumentException(MessageConstant.ERROR_EXCESS_GOAL_NAME_LENGTH);
        }
    }
}
