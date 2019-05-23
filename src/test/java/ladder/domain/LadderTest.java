package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    void 입력값이_양수일_경우() {
        assertDoesNotThrow(() -> Ladder.checkHeightIsPositive(1));
    }

    @Test
    void 입력값이_양수가_아닐_경우_예외_반환() {
        assertThrows(NumberFormatException.class, () -> Ladder.checkHeightIsPositive(0));
    }

    @Test
    void 사다리_게임_결과_매칭() {
        CustomStepsGenerator stepsGenerator = new CustomStepsGenerator();
        stepsGenerator.addCustomStpes(Arrays.asList(true, false, true));
        stepsGenerator.addCustomStpes(Arrays.asList(false, true, false));
        stepsGenerator.addCustomStpes(Arrays.asList(true, false, false));
        stepsGenerator.addCustomStpes(Arrays.asList(true, false, true));
        stepsGenerator.addCustomStpes(Arrays.asList(false, true, false));
        Ladder ladder = new Ladder(stepsGenerator, 5);

        PlayerName name = new PlayerName("pobi");
        Player player = new Player(name, 0);

        assertThat(ladder.goDownLadder(player).getPosition()).isEqualTo(3);
    }
}
