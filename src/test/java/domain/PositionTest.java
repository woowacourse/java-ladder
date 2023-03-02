package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("오른쪽으로 이동하면 위치 값이 1 늘어난다.")
    @Test
    void move_right() {
        //given
        Position position = new Position(0);

        //when
        position.moveToRight();

        //then
        assertThat(position.value()).isEqualTo(1);

    }

    @DisplayName("왼쪽으로 이동하면 위치 값이 1 줄어든다.")
    @Test
    void move_left() {
        //given
        Position position = new Position(1);

        //when
        position.moveToLeft();

        //then
        assertThat(position.value()).isEqualTo(0);
    }

    @DisplayName("왼쪽으로 이동할 수 없을 때 예외를 던진다.")
    @Test
    void move_left_fail() {
        //given
        Position position = new Position(0);

        //when

        //then
        assertThatThrownBy(position::moveToLeft)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Position의 값은 음수가 될 수 없습니다.");
    }

}
