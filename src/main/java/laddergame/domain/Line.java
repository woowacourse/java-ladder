package laddergame.domain;

import laddergame.domain.strategy.BuildStrategy;

public class Line {
    private final Points points;

    public Line(final int playerCount, final BuildStrategy buildStrategy) {
        this.points = buildStrategy.build(playerCount - 1);
    }

    public Points getPoints() {
        return points;
    }

}
