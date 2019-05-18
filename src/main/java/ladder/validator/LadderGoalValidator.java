package ladder.validator;

import ladder.MessageCollection;

public class LadderGoalValidator {

    public static String validatedGoalName(String goalName) {
        if (goalName == null || goalName.trim().isEmpty()) {
            throw new IllegalArgumentException(MessageCollection.ERROR_HAS_VALUE_EMPTY);
        }
        return goalName.trim();
    }

}
