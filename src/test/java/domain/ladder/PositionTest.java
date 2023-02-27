package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    @DisplayName("포지션 값이 음수가 들어오는 경우 예외가 발생한다.")
    void createPointFail(int value) {
        assertThatThrownBy(() -> new Position(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("위치 값은 0보다 작을 수 없습니다.");
    }

    @Test
    @DisplayName("오른쪽으로 이동하는 경우 값이 1 증가한다.")
    void moveRight() {
        int initialValue = 0;
        Position position = new Position(initialValue);

        Position movedPosition = position.moveTo(Direction.RIGHT);

        assertThat(movedPosition.getValue()).isEqualTo(initialValue + 1);
    }

    @Test
    @DisplayName("왼쪽으로 이동하는 경우 값이 1 감소한다.")
    void moveLeft() {
        int initialValue = 5;
        Position position = new Position(initialValue);

        Position movedPosition = position.moveTo(Direction.LEFT);

        assertThat(movedPosition.getValue()).isEqualTo(initialValue - 1);
    }

    @Test
    @DisplayName("움직이지 않고 아래로 이동하는 경우 값이 유지된한다.")
    void moveStraight() {
        int initialValue = 0;
        Position position = new Position(initialValue);

        Position movedPosition = position.moveTo(Direction.STRAIGHT);

        assertThat(movedPosition.getValue()).isEqualTo(initialValue);
    }

}
