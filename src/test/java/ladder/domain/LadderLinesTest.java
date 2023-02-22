package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLinesTest {


    @Test
    @DisplayName("사다리는 주어진 높이만큼의 라인을 가진다.")
    void should_HasLinesNumber_Of_GivenHeight() {
        int height = 3;
        LadderLines ladderLines = LadderLines.of(new RandomStepPointGenerator(), new LineWidth(3),
                new LadderHeight(height));

        assertThat(ladderLines.height()).isEqualTo(height);
    }
}
