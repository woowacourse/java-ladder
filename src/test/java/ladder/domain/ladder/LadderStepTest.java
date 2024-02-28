package ladder.domain.ladder;

import ladder.domain.Direction;
import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static ladder.domain.Direction.*;
import static ladder.domain.ladder.Path.EMPTY;
import static ladder.domain.ladder.Path.EXIST;
import static org.assertj.core.api.Assertions.assertThat;

class LadderStepTest {
    @Test
    @DisplayName("연속된 Path가 존재하지 않도록 수정한다.")
    void discontinuousLadderPathsTest() {
        // given
        final List<Path> continuousLadderPaths = new ArrayList<>(List.of(EXIST, EXIST, EMPTY));
        final List<Path> expectedLadderPaths = List.of(EXIST, EMPTY, EMPTY);

        // when
        final List<Path> actualLadderPaths = new LadderStep(continuousLadderPaths).getLadderPaths();

        // then
        assertThat(actualLadderPaths).containsExactlyElementsOf(expectedLadderPaths);
    }

    @ParameterizedTest
    @MethodSource("provideDirectionsForTest")
    @DisplayName("Position이 현재 Step에서 이동하게 될 방향을 올바르게 반환한다.")
    void getNextDirectionTest(final Position inputPosition, final Direction expectedDirection) {
        // given
        final LadderStep ladderStep = new LadderStep(List.of(EXIST, EMPTY));

        // when
        final Direction actualDirection = ladderStep.getNextDirection(inputPosition);

        // then
        assertThat(actualDirection).isEqualTo(expectedDirection);
    }

    private static Stream<Arguments> provideDirectionsForTest() {
        return Stream.of(
                Arguments.of(new Position(0), RIGHT),
                Arguments.of(new Position(1), LEFT),
                Arguments.of(new Position(2), NEUTRAL)
        );
    }
}
