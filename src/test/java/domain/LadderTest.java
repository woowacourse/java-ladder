package domain;

import domain.Ladder.Ladder;
import domain.Ladder.LadderHeight;
import domain.Ladder.LadderWidth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.LadderFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    
    @Test
    @DisplayName("연속하지 않는 라인으로 생성된 사다리 포맷을 반환해야한다.")
    void ladderFormatSuccessTest() {
        LadderWidth ladderWidth = LadderWidth.from(5);
        LadderHeight ladderHeight = LadderHeight.from(3);
        Ladder ladder = Ladder.create(ladderHeight, ladderWidth, new FixedPresencePointGenerator());
        assertThat(LadderFormatter.formatLadder(ladder)).isEqualTo(
                "     |-----|     |-----|     |-----|" + System.lineSeparator() +
                        "     |-----|     |-----|     |-----|" + System.lineSeparator() +
                        "     |-----|     |-----|     |-----|");
    }
    
    @Test
    @DisplayName("사다리를 실행시키면 결과 순서를 반환받는다.")
    void getSwappedSequenceTest() {
        LadderWidth width = LadderWidth.from(5);
        LadderHeight height = LadderHeight.from(3);
        Ladder ladder = Ladder.create(height, width, new FixedPresencePointGenerator());
        assertThat(ladder.getSwappedSequence(width.getWidth() + 1)).containsExactly(1, 0, 3, 2, 5, 4);
    }
}
