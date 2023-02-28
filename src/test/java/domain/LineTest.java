package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LineTest {
    @DisplayName("사다리 생성시 연속된 다리가 있을경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("lineGeneratorFailParameter")
    void validateLineBridgeTest(List<Bridge> input) {
        Assertions.assertThatThrownBy(() -> new Line(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 생성시 연속된 다리가 없을경우 정상적으로 수행된다.")
    @ParameterizedTest
    @MethodSource("lineGeneratorSuccessParameter")
    void validateLineBridgeFailTest(List<Bridge> input) {
        Assertions.assertThatCode(() -> new Line(input))
                .doesNotThrowAnyException();
    }

    // directionIndex[0] == 오른쪽으로 이동
    // directionIndex[1] == 아래로 이동
    // directionIndex[2] == 왼쪽으로 이동
    @DisplayName("유저의 위치에 맞게 사다리 이동 후 다음 position값을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,2", "2,1"})
    void calculateNextPositionTest(final int index, final int directionIndex) {
        List<Direction> directions = new ArrayList<>(List.of(Direction.RIGHT, Direction.DOWN, Direction.LEFT));
        Line line = new Line(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.NON_EXIST));
        Assertions.assertThat(line.calculateNextPosition(index)).isEqualTo(directions.get(directionIndex));
    }

    static Stream<Arguments> lineGeneratorFailParameter() {
        return Stream.of(
                Arguments.of(List.of(Bridge.EXIST, Bridge.EXIST, Bridge.NON_EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.EXIST, Bridge.EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.NON_EXIST, Bridge.EXIST, Bridge.EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.EXIST, Bridge.EXIST, Bridge.NON_EXIST))
        );
    }

    static Stream<Arguments> lineGeneratorSuccessParameter() {
        return Stream.of(
                Arguments.of(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.NON_EXIST, Bridge.EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.NON_EXIST, Bridge.NON_EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST))
        );
    }
}
