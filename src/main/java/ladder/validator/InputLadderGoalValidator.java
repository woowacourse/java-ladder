package ladder.validator;

import ladder.MessageCollection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputLadderGoalValidator {
    public static void checkLadderGoalInputAccuracy(String[] inputs, int numOfPlayers) {
        if (!isMatchPlayersAndGoals(inputs, numOfPlayers)) {
            throw new IllegalArgumentException(MessageCollection.ERROR_MISMATCH_PLAYERS_AND_GOALS);
        }
        if(isOverlapLadderGoal(inputs)){
            throw new IllegalArgumentException(MessageCollection.ERROR_OVERLAP_GOAL_NAME);
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
