package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void play() {
        LadderBuilder ladderBuilder = new LadderBuilder(new MockLadderBuildStrategy());
        Ladder ladder = ladderBuilder.build(1, 1);
        List<Integer> result = new ArrayList<>();

        result.add(0);

        assertThat(LadderGame.play(ladder)).isEqualTo(new LadderResult(result));
    }
}
