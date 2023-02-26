package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DirectionTest {

    @ParameterizedTest(name = "leftBar={0}, rightBar={1}, expected={2}")
    @MethodSource("barAndDirectionDummy")
    @DisplayName("왼쪽 오른쪽 바에 의해서 방향을 가져오는 테스트")
    void getDirectionTest(Bar leftBar, Bar rightBar, Direction expected) {
        Assertions.assertThat(Direction.getDirection(leftBar, rightBar))
                .isEqualTo(expected);
    }

    static Stream<Arguments> barAndDirectionDummy() {
        return Stream.of(
                Arguments.of(Bar.MOVABLE_BAR, Bar.UNMOVABLE_BAR, Direction.LEFT),
                Arguments.of(Bar.UNMOVABLE_BAR, Bar.MOVABLE_BAR, Direction.RIGHT),
                Arguments.of(Bar.UNMOVABLE_BAR, Bar.UNMOVABLE_BAR, Direction.STRAIGHT),
                Arguments.of(Bar.MOVABLE_BAR, null, Direction.LEFT),
                Arguments.of(null, Bar.MOVABLE_BAR, Direction.RIGHT),
                Arguments.of(null, null, Direction.STRAIGHT)
        );
    }

    @Test
    @DisplayName("방향에 대해서 이동했을 때 위치를 가져오는 테스트")
    void moveTest() {
        Assertions.assertThat(Direction.LEFT.move(1)).isEqualTo(0);
        Assertions.assertThat(Direction.RIGHT.move(1)).isEqualTo(2);
        Assertions.assertThat(Direction.STRAIGHT.move(1)).isEqualTo(1);
    }

}
