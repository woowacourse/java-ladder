/*
 * @(#)Position.java
 *
 * v 1.1.0
 *
 * 2019.05.20
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCourse, Seoul, KOREA
 * All right Reserved
 */

package ladder.domain.ladder;

/**
 * 플레이어의 위치와 이동을 위한 클래스
 *
 * @author kwonmc
 * @version 1.1.0
 */
public class Position {
    private static final String LOWER_BOUND_ERROR = "현재 위치는 0 미만 불가능";

    private int position;

    Position(int position) {
        validLowerBound(position);
        this.position = position;
    }

    private void validLowerBound(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(LOWER_BOUND_ERROR);
        }
    }

    public int getPosition() {
        return position;
    }

    Position move(Point currentPoint) {
        if (currentPoint.canMoveLeft()) {
            return moveLeft();
        }
        if (currentPoint.canMoveRight()) {
            return moveRight();
        }
        return this;
    }


    private Position moveRight() {
        return new Position(this.position + 1);
    }

    private Position moveLeft() {
        return new Position(this.position - 1);
    }
}
