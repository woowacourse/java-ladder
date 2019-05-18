package com.woowacourse.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사다리에서 각각의 수직선과 수평선의 교차점에서 이동 방향을 정하기 위한 클래스
 */
public enum Direction {
    LEFT(true, false, -1),
    RIGHT(false, true, 1),
    DOWN(false, false, 0);

    private final boolean canGoLeft;
    private final boolean canGoRight;
    private final int positionToMove;

    Direction(boolean canGoLeft, boolean canGoRight, int positionToMove) {
        if (canGoLeft && canGoRight) {
            throw new IllegalArgumentException("Each direction can't have both left and right ways");
        }
        this.canGoLeft = canGoLeft;
        this.canGoRight = canGoRight;
        this.positionToMove = positionToMove;
    }

    public Direction next(boolean nextCanGoRight) {
        return valueOf(canGoRight, nextCanGoRight);
    }

    public int getPositionToMove() {
        return positionToMove;
    }

    public static Direction valueOf(boolean canGoLeft, boolean canGoRight) {
        List<Direction> directions = Arrays.stream(values())
            .filter(d -> d.canGoLeft == canGoLeft && d.canGoRight == canGoRight)
            .collect(Collectors.toList());
        if (directions.size() == 0) {
            throw new IllegalArgumentException("No match direction");
        }
        return directions.get(0);
    }
}
