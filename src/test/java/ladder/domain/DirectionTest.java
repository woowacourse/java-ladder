package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static ladder.domain.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {
    @ParameterizedTest
    @MethodSource("providePositionsForTest")
    @DisplayName("특정 방향으로 움직인 Position 값을 올바르게 반환")
    void determineNextPositionTest(final Direction direction, final Position initialPosition, final Position expectedPosition) {
        // when
        final Position actualPosition = direction.determineNextPosition(initialPosition);

        // then
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    private static Stream<Arguments> providePositionsForTest() {
        return Stream.of(
                Arguments.of(LEFT, new Position(1), new Position(0)),
                Arguments.of(RIGHT, new Position(1), new Position(2)),
                Arguments.of(NEUTRAL, new Position(1), new Position(1))
        );
    }
}
