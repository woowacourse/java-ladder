package laddergame.domain;

import laddergame.domain.strategy.BuildStrategy;

public class Line {
    private final Points points;

    public Line(final int playerCount, final BuildStrategy buildStrategy) {
        final Points buildResult = buildStrategy.build(getBuildSize(playerCount));
        validate(getBuildSize(playerCount), buildResult);
        this.points = buildResult;
    }

    private void validate(final int buildSize, final Points points) {
        if (buildSize != points.points().size()) {
            throw new IllegalStateException();
        }
    }

    private static int getBuildSize(final int playerCount) {
        return playerCount - 1;
    }

    public Points getPoints() {
        return points;
    }

}
