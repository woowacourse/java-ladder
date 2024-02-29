package ladder.domain;

import ladder.domain.creator.LadderCreator;

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
}
