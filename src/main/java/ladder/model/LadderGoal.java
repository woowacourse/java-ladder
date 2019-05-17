package ladder.model;

import ladder.validator.LadderGoalValidator;

import java.util.Objects;

public class LadderGoal {
    public static final int MAX_LENGTH_OF_GOAL_NAME = 5;
    private static final String FORMAT_OF_ALIGNED_GOAL_NAME = "%-" + MAX_LENGTH_OF_GOAL_NAME + "s";
    private static final String BLANK_FOR_ALIGNMENT_ON_LADDER = " ";
    private final String goalName;

    public LadderGoal(final String goalName) {
        LadderGoalValidator.checkAccuracyOfGoalName(goalName);
        this.goalName = goalName.trim();
    }

    public String getGoalName() {
        return goalName;
    }

    String getAlignedGoalName() {
        return String.format(FORMAT_OF_ALIGNED_GOAL_NAME, goalName) + BLANK_FOR_ALIGNMENT_ON_LADDER;
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
