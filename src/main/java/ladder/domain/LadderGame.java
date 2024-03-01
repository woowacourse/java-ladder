package ladder.domain;

import ladder.domain.creator.LadderCreator;
import ladder.domain.item.LadderItems;
import ladder.domain.item.Person;
import ladder.domain.item.WinningItem;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public Ladder createLadder(LadderItems ladderItems, LadderHeight ladderHeight) {
        return ladderCreator.create(calculateLadderWidth(ladderItems), ladderHeight.getValue());
    }

    private int calculateLadderWidth(LadderItems ladderItems) {
        return ladderItems.countItems() - 1;
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
