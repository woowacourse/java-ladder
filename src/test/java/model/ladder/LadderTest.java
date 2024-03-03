package model.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사다리는 사다리 높이만큼의 라인을 가짐")
    @Test
    void testSizeOfLadderLines() {
        LadderHeight ladderHeight = new LadderHeight(5);
        LadderWidth ladderWidth = LadderWidth.from(4);
        Ladder ladder = RandomLadderGenerator.generateLadder(ladderHeight, ladderWidth);

        assertThat(ladder.getLines()).hasSize(5);
    }
}
