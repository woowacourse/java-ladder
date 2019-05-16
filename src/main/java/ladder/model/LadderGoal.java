package ladder.model;

import ladder.validator.LadderGoalValidator;

public class LadderGoal {

    private static final String STANDARD_FORMAT_FIRST_INDEX = "%-";
    private static final String STANDARD_FORMAT_SECOND_INDEX = "s";

    private String goalName;

    public LadderGoal(String goalName) {
        this.goalName = LadderGoalValidator.validatedGoalName(goalName);
    }

    public String getGoalName() {
        return goalName;
    }

    public String getAlignedGoalName(int maxLenOfGoalNames) {
        return String.format(STANDARD_FORMAT_FIRST_INDEX + (maxLenOfGoalNames + 1) + STANDARD_FORMAT_SECOND_INDEX, goalName);
    }
}
