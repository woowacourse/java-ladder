package ladder.domain;

import ladder.domain.creator.LadderCreator;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public Ladder processGame(People people, LadderHeight ladderHeight) {
        return ladderCreator.create(calculateLadderWidth(people), ladderHeight.getValue());
    }

    private int calculateLadderWidth(People people) {
        return people.getCount() - 1;
    }

    public Map<Person, WinningItem> findResult(Ladder ladder, LadderItems ladderItems) {
        Map<Integer, Integer> climbResult = climbAll(ladder, ladderItems.countItems());

        return ladderItems.mapResult(climbResult);
    }

    private Map<Integer, Integer> climbAll(Ladder ladder, int railCounts) {
        Map<Integer, Integer> climbResult = new HashMap<>();

        for (int railCount = 0; railCount < railCounts; railCount++) {
            climbResult.put(railCount, ladder.climb(railCount));
        }

        return climbResult;
    }
}
