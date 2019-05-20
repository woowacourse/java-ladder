package ladder.model;

import ladder.model.objectname.LadderGoalName;

import java.util.Objects;

public class LadderGoal {
    private static final String FORMAT_OF_ALIGNED_GOAL_NAME = "%-" + LadderGoalName.MAX_LENGTH_OF_GOAL_NAME + "s";
    private static final String BLANK_FOR_ALIGNMENT_ON_LADDER = " ";
    private final LadderGoalName goalName;

    public LadderGoal(final String goalName) {
        this.goalName = new LadderGoalName(goalName);
    }

    public String getGoalName() {
        return goalName.getName();
    }

    String getAlignedGoalName() {
        return String.format(FORMAT_OF_ALIGNED_GOAL_NAME, getGoalName()) + BLANK_FOR_ALIGNMENT_ON_LADDER;
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
