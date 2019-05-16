package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void playTest() {
        Ladder ladder = LadderGenerator.generate(3, 4);

        List<Integer> result = LadderGame.play(ladder);
        List<Integer> result2 = Arrays.asList(0, 1, 2, 3);

        assertThat(result).isEqualTo(result2);
    }
}
