package domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    @Test
    @DisplayName("사다리는 input 높이의 층들을 갖는다")
    void ladder() {
        final int height = 5;
        final int lineCount = 4;
        Ladder ladder = new Ladder(height, lineCount);
        assertThat(ladder.getHeight()).isEqualTo(5);
    }
}
