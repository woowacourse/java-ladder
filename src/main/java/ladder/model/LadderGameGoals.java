package ladder.model;

import ladder.constant.MessageConstant;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class LadderGameGoals {
    private final List<LadderGoal> goals;

    public LadderGameGoals(final List<LadderGoal> goals, int numOfLadderPlayers) {
        this.goals = getAccuracyOf(goals, numOfLadderPlayers);
    }

    private List<LadderGoal> getAccuracyOf(List<LadderGoal> goals, int numOfLadderPlayers) {
        if (!isMatchPlayersAndGoals(goals, numOfLadderPlayers)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_MISMATCH_NUM_OF_PLAYERS_AND_GOALS);
        }
        if (isOverlapLadderGoal(goals)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_OVERLAP_GOALS);
        }
        return goals;
    }

    private boolean isMatchPlayersAndGoals(List<LadderGoal> goals, int numOfLadderPlayers) {
        return goals.size() == numOfLadderPlayers;
    }

    private boolean isOverlapLadderGoal(List<LadderGoal> goals) {
        Set<LadderGoal> nonOverlappedGoalNames = new HashSet<>(goals);
        return nonOverlappedGoalNames.size() != goals.size();
    }

    public List<String> getAlignedGoalNames() {
        return goals.stream()
                .map(LadderGoal::getAlignedGoalName)
                .collect(toList());
    }

    public List<String> getAllGoalNames() {
        return goals.stream()
                .map(LadderGoal::getGoalName)
                .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LadderGameGoals that = (LadderGameGoals) o;
        return Objects.equals(goals, that.goals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goals);
    }
}
