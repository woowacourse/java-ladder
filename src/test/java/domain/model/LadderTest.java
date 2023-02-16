package domain.model;

import domain.vo.Height;
import domain.vo.LineCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    @Test
    @DisplayName("사다리는 input 높이의 층들을 갖는다")
    void ladder() {
        final Height height = new Height(5);
        final LineCount lineCount = new LineCount(4);
        Ladder ladder = new Ladder(height, lineCount);
        assertThat(ladder.getHeight().get()).isEqualTo(5);
    }
}
