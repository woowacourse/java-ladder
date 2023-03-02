package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import ladder.util.generator.DirectionGenerator;
import ladder.util.generator.RandomDirectionGenerator;
import ladder.util.generator.TestDirectionGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderTest {

    private static Stream<Arguments> generateDirections() {
        return Stream.of(
                Arguments.of(Lists.newArrayList(RIGHT, STAY, STAY), 0, 1),
                Arguments.of(Lists.newArrayList(RIGHT, RIGHT), 0, 0),
                Arguments.of(Lists.newArrayList(STAY, RIGHT), 0, 1)
        );
    }

    @Test
    @DisplayName("높이와 선의 개수는 동일해야 한다.")
    void should_line_count_and_height_equal() {
        final Players players = Players.from(List.of("pobi", "honux"));
        final Height height = new Height(5);

        final Ladder ladder = Ladder.of(new RandomDirectionGenerator(), players, height);

        assertThat(ladder.getLines()).hasSize(height.getValue());
    }

    @ParameterizedTest(name = "방향: {0}, 출발 위치: {1}, 도착 위치: {2}")
    @MethodSource("generateDirections")
    @DisplayName("사다리를 타면 도착 위치를 반환한다.")
    void return_end_position_when_ladder_climb(final List<Direction> directions, final int start, final int end) {
        final DirectionGenerator directionGenerator = new TestDirectionGenerator(directions);
        final Players players = Players.from(List.of("pobi", "honux"));
        final Height height = new Height(2);
        final Ladder ladder = Ladder.of(directionGenerator, players, height);

        final int result = ladder.climb(start);

        assertThat(result).isEqualTo(end);
    }
}
