package domain;

import domain.game.LadderGame;
import domain.info.Names;
import domain.ladder.Height;
import domain.ladder.Ladder;
import java.util.Arrays;
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
        Height height = new Height(1);
        Names names = new Names(Arrays.asList("a", "b", "c", "d"));
        Ladder ladder = new Ladder(names, height, booleanGenerator);
        LadderGame ladderGame = new LadderGame(names, ladder);

        Assertions.assertThat(ladderGame.getResult(0)).isEqualTo(1);
        Assertions.assertThat(ladderGame.getResult(1)).isEqualTo(0);
        Assertions.assertThat(ladderGame.getResult(2)).isEqualTo(3);
        Assertions.assertThat(ladderGame.getResult(3)).isEqualTo(2);
    }
}
