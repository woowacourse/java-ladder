package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionTest {
    @Test
    void create() {
        assertThat(new Position(1, 4)).isEqualTo(new Position(1, 4));
    }

    @Test
    void createInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Position(3, 3);
        });
    }

    @Test
    void moveLeft() {
        assertThat(new Position(2, 3).move(Direction.LEFT)).isEqualTo(new Position(1, 3));
    }

    @Test
    void moveLeftAtFirst() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Position(0, 3).move(Direction.LEFT);
        });
    }

    @Test
    void moveRight() {
        assertThat(new Position(1, 3).move(Direction.RIGHT)).isEqualTo(new Position(2, 3));
    }

    @Test
    void moveRightAtEnd() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Position(2, 3).move(Direction.RIGHT);
        });
    }
}
