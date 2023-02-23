package model;

import message.ExceptionMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGoal {
    private static final String SPLIT_DELIMITER = ",";

    private final List<Goal> ladderGoal;

    public LadderGoal(String goal, int personCount) {
        List<Goal> splitGoal = splitLadderGoal(goal);
        validateLadderGoal(splitGoal, personCount);
        this.ladderGoal = splitGoal;
    }

    private List<Goal> splitLadderGoal(String goal) {
        List<String> splitGoal = Arrays.asList(goal.split(SPLIT_DELIMITER));
        return splitGoal.stream().map(h -> new Goal(h)).collect(Collectors.toList());
    }

    private void validateLadderGoal(List<Goal> goal, int personCount) {
        if (goal.size() != personCount || goal.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_LADDER_GOAL.getExceptionMessage());
        }
    }

    public List<Goal> getLadderGoal() {
        return Collections.unmodifiableList(ladderGoal);
    }
}
