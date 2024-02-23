package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.ladder.Path.EMPTY;
import static ladder.domain.ladder.Path.EXIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LadderStepTest {
    @Test
    @DisplayName("사다리 스탭을 생성한다.")
    void createLadderStepTest() {
        // given
        final List<Path> ladderStep = List.of(EXIST, EMPTY, EXIST, EMPTY);

        // when & then
        assertThatCode(() -> new LadderStep(ladderStep))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("연속된 사다리 발판이 생성자의 매개변수로 넘어올 경우 보정된다.")
    void checkContinuousPathTest() {
        // given
        final List<Path> continuousLadderStep = List.of(EXIST, EXIST, EXIST, EMPTY);

        // when
        final LadderStep ladderStep = new LadderStep(continuousLadderStep);

        // then
        final List<Path> correctedLadderStep = ladderStep.getLadderPaths();
        assertThat(correctedLadderStep).isEqualTo(List.of(EXIST, EMPTY, EXIST, EMPTY));
    }
}
