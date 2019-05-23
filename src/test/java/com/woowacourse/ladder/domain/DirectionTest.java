package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {
    Direction noneDirection;
    Direction leftDirection;
    Direction rightDirection;
    @BeforeEach
    void setUp() {
        noneDirection = new Direction(false,false);
        leftDirection = new Direction(true,false);
        rightDirection = new Direction(false,true);
    }

    @Test
    void 처음direction을_생성하는_테스트() {
        assertThat(Direction.first(false)).isEqualTo(noneDirection);
        assertThat(Direction.first(true)).isEqualTo(noneDirection);
    }

    @Test
    void 일반direction을_생성하는_테스트() {

        assertThat(Direction.middle(true,false)).isEqualTo(leftDirection);
    }

    @Test
    void 일반direction을_생성할때_양쪽이모두다리가있으면_예외를던지는지_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Direction.middle(true,true);
        });
    }

    @Test
    void 마지막direction을_생성하는_테스트() {
        assertThat(Direction.last(true)).isEqualTo(leftDirection);
        assertThat(Direction.last(false)).isEqualTo(rightDirection);
    }

    @Test
    void move_left테스트() {
        assertThat(leftDirection.move()).isEqualTo(-1);
    }

    @Test
    void move_right테스트() {
        assertThat(noneDirection.move()).isEqualTo(1);
    }

    @Test
    void move_stop테스트() {
        assertThat(noneDirection.move()).isEqualTo(0);
    }
}
