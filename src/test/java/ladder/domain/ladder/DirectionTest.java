package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DirectionTest {

    @ParameterizedTest(name = "leftBar={0}, rightBar={1}, expected={2}")
    @MethodSource("barAndDirectionDummy")
    @DisplayName("")
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

}
