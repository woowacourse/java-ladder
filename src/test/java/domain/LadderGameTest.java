package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BooleanGenerator;
import utils.TrueBooleanGenerator;

public class LadderGameTest {
    public BooleanGenerator booleanGenerator;

    @BeforeEach
    void setup() {
        booleanGenerator = new TrueBooleanGenerator();
    }

    @DisplayName("생성된 사다리를 타는 것을 테스트한다.")
    @Test
    void validLinesGameTest() {
        Ladder ladder = new Ladder(4, 1, booleanGenerator);
        LadderGame ladderGame = new LadderGame(4, ladder.getFloors());

        Assertions.assertThat(ladderGame.getResult(0)).isEqualTo(1);
        Assertions.assertThat(ladderGame.getResult(1)).isEqualTo(0);
        Assertions.assertThat(ladderGame.getResult(2)).isEqualTo(3);
        Assertions.assertThat(ladderGame.getResult(3)).isEqualTo(2);
    }
}
