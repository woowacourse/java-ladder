package ladder.model;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class LadderGameGoals {

    private List<LadderGoal> goals;

    public LadderGameGoals(List<LadderGoal> goals) {
        this.goals = goals;
    }

    public int getMaxLenOfGoalNames(){
        return goals.stream().map(LadderGoal::getGoalName)
                .map(String::length)
                .max(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<String> getAlignedGoalNames() {
        return goals.stream().map(goal -> goal.getAlignedGoalName(getMaxLenOfGoalNames())).collect(Collectors.toList());
    }

}
