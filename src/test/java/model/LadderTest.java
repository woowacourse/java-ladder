package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리는 사다리 높이만큼의 라인을 가진다")
    @Test
    void testSizeOfLadderLines() {
        LadderHeight ladderHeight = new LadderHeight(5);
        Ladder ladder = Ladder.fromHeightAndBridgeCount(ladderHeight, new LineGenerator(1));
        assertThat(ladder.getLines().size())
                .isEqualTo(5);
    }
}
