package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PresentStepGenerator;

class LadderResultTest {

    @Test
    @DisplayName("사다리 결과를 잘 생성하고 모든 결과를 확인한다.")
    void getAllResultTest() {
        Ladder ladder = new Ladder(2, 3, new PresentStepGenerator());
        LadderResult ladderResult = new LadderResult(ladder, 3);
        Map<Integer, Integer> expectedResult = Map.of(0, 1, 1, 0, 2, 2);
        Assertions.assertThat(ladderResult.getAllResult()).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("사다리 결과를 잘 생성하고 하나의 결과를 확인한다.")
    void getOneResultTest() {
        Ladder ladder = new Ladder(2, 3, new PresentStepGenerator());
        LadderResult ladderResult = new LadderResult(ladder, 3);
        Assertions.assertThat(ladderResult.getOneResult(0)).isEqualTo(1);
    }
}
