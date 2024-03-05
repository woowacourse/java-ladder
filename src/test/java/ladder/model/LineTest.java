package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static ladder.model.LadderPath.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    @Test
    @DisplayName("STAY 가 아닌 경로가 연속된다면 예외가 발생한다.")
    void throwsExceptionWhenContinuousPathExistTest() {
        List<LadderPath> continuousPath = List.of(RIGHT, LEFT, RIGHT, RIGHT, STAY);

        assertThatThrownBy(() -> new Line(continuousPath))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("RIGHT 오른쪽에 LEFT가 없다면 예외가 발생한다.")
    void throwsExceptionWhenLeftNotExistBeforeRight() {
        List<LadderPath> notRLPath = List.of(STAY, STAY, RIGHT, STAY, STAY);

        assertThatThrownBy(() -> new Line(notRLPath))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LEFT 왼쪽에 RIGHT가 없다면 예외가 발생한다.")
    void throwsExceptionWhenRightNotExistAfterLeft() {
        List<LadderPath> notLRPath = List.of(STAY, STAY, LEFT, STAY, STAY);

        assertThatThrownBy(() -> new Line(notLRPath))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("첫 번째 경로가 왼쪽이라면 예외가 발생한다.")
    void throwsExceptionWhenLeftFirst() {
        List<LadderPath> leftFirstPath = List.of(LEFT, STAY, STAY, STAY, STAY);

        assertThatThrownBy(() -> new Line(leftFirstPath))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 경로가 오른쪽이라면 예외가 발생한다.")
    void throwsExceptionWhenRightLast() {
        List<LadderPath> rightLastPath = List.of(STAY, STAY, STAY, STAY, RIGHT);

        assertThatThrownBy(() -> new Line(rightLastPath))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "초기 위치: {0} -> 내려온 후 위치: {1}")
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2", "4,4", "5,6", "6,5"})
    @DisplayName("사다리의 가로줄 한 줄(Line)을 내려온 결과는 각 지점의 direction 값에 따라 원소를 이동시킨 것과 같다.")
    void climbDownTest(int initialPosition, int expected) {
        List<LadderPath> validPath = List.of(RIGHT, LEFT, RIGHT, LEFT, STAY, RIGHT, LEFT);
        Line line = new Line(validPath);

        assertThat(line.climbDown(initialPosition))
                .isEqualTo(expected);
    }
}
