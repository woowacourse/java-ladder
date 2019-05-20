package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void play() {
        LadderBuilder ladderBuilder = new LadderBuilder(new MockLadderBuildStrategy());
        Ladder ladder = ladderBuilder.build(new LadderHeight(1), 2);
        List<Integer> result = Arrays.asList(1, 0);

        assertThat(ladder.play()).isEqualTo(new LadderResult(result));
    }
}
