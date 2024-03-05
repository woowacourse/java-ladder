package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import static ladder.domain.ladder.direction.LadderDirection.NONE;
import static ladder.domain.ladder.direction.LadderDirection.RIGHT;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ladder.domain.attribute.Height;
import ladder.domain.attribute.Width;

class LadderTest {

    static Stream<Arguments> climbDownFromTest() {
        return Stream.of(
                Arguments.of(new LadderPosition(0), 1),
                Arguments.of(new LadderPosition(1), 0),
                Arguments.of(new LadderPosition(2), 3),
                Arguments.of(new LadderPosition(3), 2)
        );
    }

    @DisplayName("사람 수와 높이를 입력받아 사다리를 생성한다.")
    @Test
    void ladderConstructTest() {
        Ladder ladder = Ladder.of(
                new Height(4),
                new Width(5),
                () -> NONE
        );

        List<LadderRow> ladderRows = ladder.getLadderRows();

        assertThat(ladderRows).hasSize(4);
    }

    @DisplayName("사다리의 출발점을 입력하면 도착점을 반환한다.")
    @MethodSource
    @ParameterizedTest
    void climbDownFromTest(LadderPosition ladderPosition, int column) {
        Ladder ladder = Ladder.of(
                new Height(5),
                new Width(4),
                () -> RIGHT
        );

        LadderPosition endPosition = ladder.climbDownFrom(ladderPosition);
        int endPositionColumn = endPosition.column();

        assertThat(endPositionColumn).isEqualTo(column);
    }
}
