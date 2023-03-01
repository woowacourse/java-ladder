package domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {


    @DisplayName("moveLeft를 하면 Position 내부의 값이 1 감소한다.")
    @Test
    void move_left_value_minus_one() {
        // given
        Position position = new Position(2);
        // when
        position.moveLeft();
        // then
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @DisplayName("moveRight를 하면 Position 내부의 값이 1 증가한다.")
    @Test
    void move_right_value_plus_one() {
        // given
        Position position = new Position(2);
        // when
        position.moveRight();
        // then
        assertThat(position.getPosition()).isEqualTo(3);
    }

    @DisplayName("position 내부의 값과 같으면 true를 반환한다.")
    @Test
    void is_same_position() {
        // given
        Position position = new Position(1);
        // when
        boolean result = position.same(1);
        // then
        assertThat(result).isTrue();
    }

    @DisplayName("position 내부의 값과 다르면 false 반환한다.")
    @Test
    void is_not_same_position() {
        // given
        Position position = new Position(1);
        // when
        boolean result = position.same(2);
        // then
        assertThat(result).isFalse();
    }
}
