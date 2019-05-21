package ladder.model.objectname;

import ladder.constant.MessageConstant;

public class LadderGoalName extends LadderObjectName {
    public static final int MAX_LENGTH_OF_GOAL_NAME = 5;

    public LadderGoalName(String name) {
        super(name);
        checkMaxLenOfGoalName(name);
    }

    private void checkMaxLenOfGoalName(String name) {
        if (name.length() > MAX_LENGTH_OF_GOAL_NAME) {
            throw new IllegalArgumentException(MessageConstant.ERROR_EXCESS_GOAL_NAME_LENGTH);
        }
    }
}
