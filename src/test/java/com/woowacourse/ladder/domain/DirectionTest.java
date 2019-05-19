package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @Test
    void createNextDirection() {
        assertThat(Direction.LEFT.next(true)).isEqualTo(Direction.RIGHT);
    }

    @Test
    void moveLeft() {
        assertThat(Direction.LEFT.getPositionToMove()).isEqualTo(-1);
    }

    @Test
    void moveRight() {
        assertThat(Direction.RIGHT.getPositionToMove()).isEqualTo(1);
    }

    @Test
    void moveDown() {
        assertThat(Direction.DOWN.getPositionToMove()).isEqualTo(0);
    }

    @Test
    void matchState() {
        assertThat(Direction.DOWN.matchState(false, false)).isTrue();
        assertThat(Direction.LEFT.matchState(false, true)).isFalse();
    }
}
