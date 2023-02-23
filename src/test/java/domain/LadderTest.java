package domain;

import domain.util.PointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.LadderView;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("연속하지 않는 라인으로 생성된 사다리 포맷을 반환해야한다.")
    void ladderFormatSuccessTest() {
        LadderWidth ladderWidth = new LadderWidth(5);
        LadderHeight ladderHeight = new LadderHeight(3);
        Ladder ladder = Ladder.create(ladderHeight, ladderWidth, PointGenerator.getInstance(false));
        assertThat(LadderView.formatLadder(ladder)).isEqualTo(
                "     |-----|     |-----|     |-----|" + System.lineSeparator() +
                        "     |-----|     |-----|     |-----|" + System.lineSeparator() +
                        "     |-----|     |-----|     |-----|");
    }

}
