package laddergame.domain;

import laddergame.domain.strategy.BuildStrategy;

public class Line {
    private static final String BUILD_SIZE_ERROR = "다리 생성 여부의 크기는 건설 가능 크기와 같아야 합니다. 입력된 다리 생성 크기: %d, 건설 가능 크기: %d";
    private final Points points;

    public Line(final int playerCount, final BuildStrategy buildStrategy) {
        final Points buildResult = buildStrategy.build(getBuildSize(playerCount));
        validate(getBuildSize(playerCount), buildResult);
        this.points = buildResult;
    }

    private void validate(final int buildSize, final Points points) {
        if (buildSize != points.getPointSize()) {
            throw new IllegalStateException(String.format(BUILD_SIZE_ERROR, buildSize, points.getPointSize()));
        }
    }

    public Direction getDirection(final int position) {
        if (position == 0) {
            return getFirstDirection();
        }
        if (position == points.getPointSize()) {
            return getLastDirection();
        }
        return getMiddleDirection(position);
    }

    private Direction getFirstDirection() {
        if (getPoints().isFirstPointBuilt()) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    private Direction getLastDirection() {
        if (getPoints().isLastPointBuilt()) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    private Direction getMiddleDirection(final int position) {
        if (points.isPositionBuilt(position)) {
            return Direction.RIGHT;
        }
        if (points.isPositionBuilt(position - 1)) {
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
