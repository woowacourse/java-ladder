package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.PathAvailability.EMPTY;
import static ladder.domain.PathAvailability.EXIST;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LadderStepTest {
    @Test
    @DisplayName("사다리 스탭을 생성한다.")
    void createLadderStepTest() {
        // given
        List<PathAvailability> ladderStep = List.of(EXIST, EMPTY, EXIST, EMPTY);

        // when & then
        assertThatCode(() -> new LadderStep(ladderStep))
                .doesNotThrowAnyException();
    }
}
