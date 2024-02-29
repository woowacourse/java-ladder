package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class PositionTest {

    @ParameterizedTest
    @EnumSource(value = Direction.class)
    @DisplayName("정해진 뱡향에 따라 가로로 이동한다.")
    void moveHorizontallyTest(Direction direction) {
        //given
        Position position = new Position(3,5);

        //when
        position.moveHorizontally(direction);

        //then
        Assertions.assertThat(position)
                .isEqualTo(new Position(3 + direction.getValue(), 5));
    }

    @Test
    @DisplayName("가로 이동하면 아래로 1만큼 이동한다.")
    void moveToDownStairTest() {
        //given
        Position position = new Position(1,2);

        //when
        position.moveToDownStair();

        //then
        Assertions.assertThat(position)
                .isEqualTo(new Position(1,1));
    }

    @Test
    @DisplayName("-1보다 낮은 위치로 내려가는 시도를 하면 예외를 발생한다.")
    void moveToNegativeStairTest() {
        //given
        Position position = new Position(1,-1);

        //when & then
        assertThatThrownBy(position::moveToDownStair)
                .isInstanceOf(IllegalStateException.class);
    }
}