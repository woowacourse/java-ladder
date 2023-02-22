package domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @DisplayName("Position 내부 값이 1이면 left end이다.")
    @Test
    void is_left_end_true() {
        // given
        Position position = new Position(1);

        // when
        boolean result = position.isLeftEnd();

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("Position 내부 값이 1이 아니면 left end가 아니다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 5, 10})
    void is_left_end_false(int wrongValue) {
        // given
        Position position = new Position(wrongValue);

        // when
        boolean result = position.isLeftEnd();

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("Position 내부 값과 주어진 값이 같으면 isRightEnd는 true를 반환한다.")
    @Test
    void is_right_end_true() {
        // given
        Position position = new Position(5);

        // when
        boolean result = position.isRightEnd(5);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("Position 내부 값과 주어진 값이 다르면 isRightEnd는 false를 반환한다.")
    @Test
    void is_right_end_false() {
        // given
        Position position = new Position(5);

        // when
        boolean result = position.isRightEnd(4);

        // then
        assertThat(result).isFalse();
    }

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
}
