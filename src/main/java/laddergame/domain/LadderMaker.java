package laddergame.domain;

import laddergame.util.PointGenerator;

public class LadderMaker {

    private final PointGenerator pointGenerator;

    public LadderMaker(PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
    }

    public Ladder make(int playerCount, LadderHeight ladderHeight) {
        return new Ladder(playerCount, ladderHeight, pointGenerator);
    }
}
