package model;

import message.ExceptionMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGoal {
    private static final String SPLIT_DELIMITER = ",";

    private final List<Result> ladderGoal;

    public LadderGoal(String result, int personCount) {
        List<Result> splitGoal = splitLadderGoal(result);
        validateLadderGoal(splitGoal, personCount);
        this.ladderGoal = splitGoal;
    }

    private List<Result> splitLadderGoal(String goal) {
        List<String> splitGoal = Arrays.asList(goal.split(SPLIT_DELIMITER));
        return splitGoal.stream().map(h -> new Result(h)).collect(Collectors.toList());
    }

    private void validateLadderGoal(List<Result> goal, int personCount) {
        if (goal.size() != personCount || goal.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_LADDER_GOAL.getExceptionMessage());
        }
    }

    public List<Result> getLadderGoal() {
        return Collections.unmodifiableList(ladderGoal);
    }
}
