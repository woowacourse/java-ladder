package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.ladder.Path.EMPTY;
import static ladder.domain.ladder.Path.EXIST;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LadderStepTest {
    @Test
    @DisplayName("사다리 스탭을 생성한다.")
    void createLadderStepTest() {
        // given
        List<Path> ladderStep = List.of(EXIST, EMPTY, EXIST, EMPTY);

        // when & then
        assertThatCode(() -> new LadderStep(ladderStep))
                .doesNotThrowAnyException();
    }
}
