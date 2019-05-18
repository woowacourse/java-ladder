package ladder.validator;

import ladder.constant.MessageConstant;

public class LadderGoalValidator {

    public static String validatedGoalName(String goalName) {
        if (goalName == null || goalName.trim().isEmpty()) {
            throw new IllegalArgumentException(MessageConstant.ERROR_HAS_VALUE_EMPTY);
        }
        return goalName.trim();
    }

}
