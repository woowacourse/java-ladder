package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {
    Direction direction;
    @Test
    void creat() {
        direction =  new Direction(true,false);
    }

    @Test
    void 처음direction을_생성하는_테스트() {
        assertThat(Direction.first(false)).isEqualTo(new Direction(false,false));
        assertThat(Direction.first(true)).isEqualTo(new Direction(false,true));
    }

    @Test
    void 일반direction을_생성하는_테스트() {
        assertThat(Direction.middle(true,false)).isEqualTo(new Direction(true,false));
    }

    @Test
    void 일반direction을_생성할때_양쪽이모두다리가있으면_예외를던지는지_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Direction.middle(true,true);
        });
    }

    @Test
    void 마지막direction을_생성하는_테스트() {
        assertThat(Direction.last(true)).isEqualTo(new Direction(true,false));
        assertThat(Direction.last(false)).isEqualTo(new Direction(false,false));
    }

    @Test
    void move_left테스트() {
        Direction direction = new Direction(true,false);
        assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void move_right테스트() {
        Direction direction = new Direction(true,true);
        assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void move_stop테스트() {
        Direction direction = new Direction(false,false);
        assertThat(direction.move()).isEqualTo(0);
    }
}
