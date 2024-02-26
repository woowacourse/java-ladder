package ladder.domain.ladder;

import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        assertThat(actualLadderPaths)
                .containsExactlyElementsOf(expectedLadderPaths);
    }

    @Test
    @DisplayName("Position이 현재 Step에서 이동하게 될 방향을 올바르게 반환한다.")
    void getNextDirectionTest() {
        // given
        LadderStep ladderStep = new LadderStep(List.of(EXIST, EMPTY));
        Position expectedRight = new Position(0);
        Position expectedLeft = new Position(1);
        Position expectedNeutral = new Position(2);

        // when & then
        assertThat(ladderStep.getNextDirection(expectedRight)).isEqualTo(RIGHT);
        assertThat(ladderStep.getNextDirection(expectedLeft)).isEqualTo(LEFT);
        assertThat(ladderStep.getNextDirection(expectedNeutral)).isEqualTo(NEUTRAL);
    }
}
