package domain;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.result.LadderResult;
import domain.result.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PresentStepGenerator;

class LadderResultTest {
    @Test
    @DisplayName("사다리 결과를 잘 생성하고 하나의 결과를 확인한다.")
    void getOneResultTest() {
        Ladder ladder = new Ladder(new Height(2), 3, new PresentStepGenerator());
        LadderResult ladderResult = new LadderResult(ladder, 3);
        Assertions.assertThat(ladderResult.getOneResult(new Position(0))).isEqualTo(new Position(0));
    }
}
