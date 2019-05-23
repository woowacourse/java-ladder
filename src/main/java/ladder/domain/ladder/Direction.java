/*
 * @(#)Direction.java
 *
 * v 1.2.0
 *
 * 2019.05.23
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCourse, Seoul, KOREA
 * All right Reserved
 */
package ladder.domain.ladder;

import java.util.Objects;

/**
 * Point 의 방향을 나타내기 위한 클래스
 *
 * @author mrkwon
 * @version 1.2.0
 */
public class Direction {
    private Boolean direction;

    public Direction(Boolean direction) {
        this.direction = direction;
    }

    private Boolean getDirection() {
        return direction;
    }

    public static Direction empty() {
        return new Direction(false);
    }

    public Boolean is() {
        return this.getDirection();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction1 = (Direction) o;
        return direction == direction1.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
