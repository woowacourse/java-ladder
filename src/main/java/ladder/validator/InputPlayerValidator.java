package ladder.validator;

import ladder.MessageCollection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputPlayerValidator {

    public static void checkPlayerInputAccuracy(String[] inputs) {
        if (isOnePlayer(inputs)) {
            throw new IllegalArgumentException(MessageCollection.ERROR_ONE_PLAYER);
        }

        if (isOverlapPlayer(inputs)) {
            throw new IllegalArgumentException(MessageCollection.ERROR_OVERLAP_PLAYERS);
        }
    }

    private static boolean isOnePlayer(String[] inputs) {
        return inputs.length == 1;
    }

    private static boolean isOverlapPlayer(String[] inputs) {
        Set<String> checkOverlapNames = new HashSet<>(Arrays.asList(inputs));
        return checkOverlapNames.size() != inputs.length;
    }
}
