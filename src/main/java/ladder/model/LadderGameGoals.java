package ladder.model;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class LadderGameGoals {
    private final List<LadderGoal> goals;

    public LadderGameGoals(final List<LadderGoal> goals) {
        this.goals = goals;
    }

    public List<String> getAlignedGoalNames() {
        return goals.stream().map(LadderGoal::getAlignedGoalName).collect(Collectors.toList());
    }

    public List<String> getAllGoalNames() {
        return goals.stream().map(LadderGoal::getGoalName).collect(Collectors.toList());
    }
}
