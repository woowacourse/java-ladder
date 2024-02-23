package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        final List<Path> actualLadderPaths = new LadderStep(continuousLadderPaths).ladderPaths();

        // then
        assertThat(actualLadderPaths)
                .containsExactlyElementsOf(expectedLadderPaths);
    }
}
