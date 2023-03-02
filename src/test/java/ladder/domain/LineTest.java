package ladder.domain;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import ladder.util.generator.DirectionGenerator;
import ladder.util.generator.TestDirectionGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LineTest {

    private static Stream<Arguments> generateDirections() {
        return Stream.of(
                Arguments.of(Lists.newArrayList(RIGHT, STAY, STAY), new Direction[]{RIGHT, LEFT, STAY, STAY}, 4),
                Arguments.of(Lists.newArrayList(RIGHT, RIGHT), new Direction[]{RIGHT, LEFT, RIGHT, LEFT}, 4),
                Arguments.of(Lists.newArrayList(RIGHT, STAY), new Direction[]{RIGHT, LEFT, STAY}, 3)
        );
    }

    @ParameterizedTest(name = "입력: {0}, 생성된 방향: {1}, 개수: {2}")
    @MethodSource("generateDirections")
    @DisplayName("선은 개수에 알맞은 방향 정보를 가진다.")
    void direction_size_equal_count(final List<Direction> directions, final Direction[] expected,
                                    final int count) {
        final DirectionGenerator directionGenerator = new TestDirectionGenerator(directions);
        final Line line = Line.of(directionGenerator, count);

        assertThat(line.getDirections()).containsExactly(expected);
    }

    @ParameterizedTest(name = "출발 위치: {0}, 도착 위치: {1}")
    @CsvSource(value = {"0:1", "1:0", "2:2"}, delimiter = ':')
    @DisplayName("해당 위치에서 알맞은 방향으로 이동시킨다.")
    void move_to_direction(final int start, final int end) {
        final Line line = new Line(List.of(RIGHT, LEFT, STAY));

        final int result = line.moveFrom(start);

        assertThat(result).isEqualTo(end);
    }
}
