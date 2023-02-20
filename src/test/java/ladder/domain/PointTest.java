package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PointTest {
    Point point;

    @BeforeEach
    void makePoint() {
        point = new Point(2);
    }

    @Test
    @DisplayName("아래로 내려가는 동작이 제대로 일어나는지 테스트")
    void validMoveVertical() {
        // when
        point.moveVertical();

        // then
        Assertions.assertThat(point.getVerticalPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource("provideEnumValues")
    @DisplayName("왼쪽으로 이동, 가만히 있는지, 오른쪽으로 이동하는지 테스트")
    void validMoveHorizontal(Direction direction, int expected) {
        // when
        point.moveHorizontal(direction);

        // then
        Assertions.assertThat(point.getHorizontalPosition()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideEnumValues() {
        return Stream.of(
                Arguments.of(Direction.LEFT, 1),
                Arguments.of(Direction.STAY, 2),
                Arguments.of(Direction.RIGHT, 3)
        );
    }
}
