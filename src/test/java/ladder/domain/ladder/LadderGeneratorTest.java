package ladder.domain.ladder;

import ladder.domain.rule.RandomPointLadderRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderGeneratorTest {
    @Test
    void 사다리생성하기() {
        assertThat(LadderGenerator.generate(3, 1, new ForcedTrueRule()))
                .isEqualTo(new Ladder(Arrays.asList(LineGenerator.generate(3, new ForcedTrueRule()))));
    }

    @Test
    void 폭이2보다작은사다리생성불가() {
        assertThrows(IllegalArgumentException.class, () -> {
            LadderGenerator.generate(1, 1, new RandomPointLadderRule());
        });
    }

    @Test
    void 높이가1보다작은사다리생성불가() {
        assertThrows(IllegalArgumentException.class, () -> {
            LadderGenerator.generate(2, 0, new RandomPointLadderRule());
        });
    }
}
