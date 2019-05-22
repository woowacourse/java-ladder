package ladder.model;

import ladder.MessageCollection;

import java.util.Objects;

public class LadderGoal {

    private static final String STANDARD_FORMAT_FIRST_INDEX = "%-";
    private static final String STANDARD_FORMAT_SECOND_INDEX = "s";

    private String goalName;

    public LadderGoal(String goalName) {
        this.goalName = validatedGoalName(goalName);
    }

    private String validatedGoalName(String goalName) {
        if (goalName == null || goalName.trim().isEmpty()) {
            throw new IllegalArgumentException(MessageCollection.ERROR_HAS_VALUE_EMPTY);
        }
        return goalName.trim();
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
