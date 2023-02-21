package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import ladder.domain.generator.DirectionGenerator;
import ladder.domain.generator.RandomDirectionGenerator;
import ladder.domain.generator.TestDirectionGenerator;
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
    @DisplayName("사다리 높이만큼 선을 생성한다.")
    void validLadder() {
        final Players players = new Players(List.of("pobi", "crong"));
        final Height height = new Height(5);

        final Ladder ladder = Ladder.of(new RandomDirectionGenerator(), players, height);

        assertThat(ladder.getLines()).hasSize(5);
    }

    @ParameterizedTest
    @MethodSource("generateDirections")
    @DisplayName("사다리를 탄다.")
    void climbLadder(final List<Direction> directions, final int position, final int expected) {
        final DirectionGenerator directionGenerator = new TestDirectionGenerator(directions);
        final Players players = new Players(List.of("pobi", "crong"));
        final Height height = new Height(2);
        final Ladder ladder = Ladder.of(directionGenerator, players, height);

        final int result = ladder.climb(position);

        assertThat(result).isEqualTo(expected);
    }
}
