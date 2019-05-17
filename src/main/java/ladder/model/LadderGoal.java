package ladder.model;

import ladder.validator.LadderGoalValidator;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGoal that = (LadderGoal) o;
        return Objects.equals(goalName, that.goalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goalName);
    }
}
