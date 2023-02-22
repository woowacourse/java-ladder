package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BooleanGenerator;
import utils.TrueBooleanGenerator;

public class LinesGameTest {
    public BooleanGenerator booleanGenerator;

    @BeforeEach
    void setup() {
        booleanGenerator = new TrueBooleanGenerator();
    }

    @DisplayName("생성된 사다리를 타는 것을 테스트한다.")
    @Test
    void validLinesGameTest() {
        Lines lines = new Lines(4, 1, booleanGenerator);
        LinesGame linesGame = new LinesGame(lines.getLines());

        Assertions.assertThat(linesGame.getResult(0)).isEqualTo(1);
        Assertions.assertThat(linesGame.getResult(1)).isEqualTo(0);
        Assertions.assertThat(linesGame.getResult(2)).isEqualTo(3);
        Assertions.assertThat(linesGame.getResult(3)).isEqualTo(2);
    }
}
