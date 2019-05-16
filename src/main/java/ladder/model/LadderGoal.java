package ladder.model;

import ladder.validator.LadderGoalValidator;

public class LadderGoal {
    private String goalName;

    public LadderGoal(String goalName) {
        this.goalName = LadderGoalValidator.validatedGoalName(goalName);
    }

    public String getGoalName() {
        return goalName;
    }
}
