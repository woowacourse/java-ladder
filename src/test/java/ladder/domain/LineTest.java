package ladder.domain;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import ladder.domain.generator.DirectionGenerator;
import ladder.domain.generator.TestDirectionGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LineTest {

    private static Stream<Arguments> generateDirections() {
        return Stream.of(
                Arguments.of(Lists.newArrayList(RIGHT, STAY, STAY), new Direction[]{RIGHT, LEFT, STAY, STAY}, 4),
                Arguments.of(Lists.newArrayList(RIGHT, RIGHT), new Direction[]{RIGHT, LEFT, RIGHT, LEFT}, 4),
                Arguments.of(Lists.newArrayList(RIGHT, STAY), new Direction[]{RIGHT, LEFT, STAY}, 3)
        );
    }

    @ParameterizedTest(name = "입력: {0}, 출력: {1}, 개수: {2}")
    @MethodSource("generateDirections")
    @DisplayName("발판이 정상적으로 만들어진다.")
    void validLine(final List<Direction> directions, final Direction[] expected, final int directionCount) {
        final DirectionGenerator directionGenerator = new TestDirectionGenerator(directions);
        final Line line = Line.of(directionGenerator, directionCount);

        assertThat(line.getDirections()).containsExactly(expected);
    }
}
