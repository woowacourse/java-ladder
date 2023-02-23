package domain;

import domain.Ladder.Ladder;
import domain.Ladder.LadderHeight;
import domain.Ladder.LadderWidth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.LadderView;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("연속하지 않는 라인으로 생성된 사다리 포맷을 반환해야한다.")
    void ladderFormatSuccessTest() {
        LadderWidth ladderWidth = LadderWidth.from(5);
        LadderHeight ladderHeight = LadderHeight.from(3);
        Ladder ladder = Ladder.create(ladderHeight, ladderWidth, new FixedPresencePointGenerator());
        assertThat(LadderView.formatLadder(ladder)).isEqualTo(
                "     |-----|     |-----|     |-----|" + System.lineSeparator() +
                        "     |-----|     |-----|     |-----|" + System.lineSeparator() +
                        "     |-----|     |-----|     |-----|");
    }

}
