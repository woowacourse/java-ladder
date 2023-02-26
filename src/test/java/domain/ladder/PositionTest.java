package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @ParameterizedTest
    @CsvSource(value = {"false,false,true:true", "false,false,false:false"}, delimiter = ':')
    @DisplayName("포지션 객체는 왼쪽으로 이동할 수 있는지 판단할 수 있다..")
    void getLeftMoveFlagWithPosition(String inputPoints, boolean expectedFlag) {
        List<Boolean> points = Arrays.stream(inputPoints.split(","))
                .map(Boolean::valueOf)
                .collect(Collectors.toList());

        Position position = new Position(points.size() - 1);
        boolean resultFlag = position.canMoveRight(points, position);

        assertThat(resultFlag).isEqualTo(expectedFlag);
    }

    @ParameterizedTest
    @CsvSource(value = {"false,false,true:true", "false,false,false:false"}, delimiter = ':')
    @DisplayName("포지션 객체는 오른쪽으로 이동할 수 있는지 판단할 수 있다..")
    void getRightMoveFlagWithPosition(String inputPoints, boolean expectedFlag) {
        List<Boolean> points = Arrays.stream(inputPoints.split(","))
                .map(Boolean::valueOf)
                .collect(Collectors.toList());

        Position position = new Position(points.size() - 1);
        boolean resultFlag = position.canMoveRight(points, position);

        assertThat(resultFlag).isEqualTo(expectedFlag);
    }

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

        Position movedPosition = position.moveDirection(Direction.RIGHT);

        assertThat(movedPosition.getValue()).isEqualTo(initialValue + 1);
    }

    @Test
    @DisplayName("왼쪽으로 이동하는 경우 값이 1 감소한다.")
    void moveLeft() {
        int initialValue = 5;
        Position position = new Position(initialValue);

        Position movedPosition = position.moveDirection(Direction.LEFT);

        assertThat(movedPosition.getValue()).isEqualTo(initialValue - 1);
    }

    @Test
    @DisplayName("움직이지 않고 아래로 이동하는 경우 값이 유지된한다.")
    void moveStraight() {
        int initialValue = 0;
        Position position = new Position(initialValue);

        Position movedPosition = position.moveDirection(Direction.STRAIGHT);

        assertThat(movedPosition.getValue()).isEqualTo(initialValue);
    }

}
