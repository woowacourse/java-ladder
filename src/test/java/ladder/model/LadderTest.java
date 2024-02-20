package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("지정된 높이와 폭의 사다리를 생성할 수 있다.")
    void createLadderTest() {
        LadderHeight height = new LadderHeight(5);
        int width = 7;

        Ladder ladder = Ladder.from(height, width);

        int actualHeight = ladder.getHeight();
        int actualWidth = ladder.getWidth();
        int expectedHeight = 5;
        int expectedWidth = 7;

        assertThat(actualHeight).isEqualTo(expectedHeight);
        assertThat(actualWidth).isEqualTo(expectedWidth);
    }
}
