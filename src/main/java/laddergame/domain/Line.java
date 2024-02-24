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

    public Direction getDirection(final int position) {
        if (position == 0) {
            return getFirstDirection();
        }
        if (position == points.points().size()) {
            return getLastDirection();
        }
        return getMiddleDirection(position);
    }

    private Direction getFirstDirection() {
        if (points.points().get(0).isBuilt()) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    private Direction getLastDirection() {
        if (points.points().get(points.points().size() - 1).isBuilt()) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    private Direction getMiddleDirection(final int position) {
        if (points.points().get(position).isBuilt()) {
            return Direction.RIGHT;
        }
        if (points.points().get(position - 1).isBuilt()) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    private static int getBuildSize(final int playerCount) {
        return playerCount - 1;
    }

    public Points getPoints() {
        return points;
    }

}
