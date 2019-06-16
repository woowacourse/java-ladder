package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {
    @Test
    void putAndGetTarget() {
        LadderResult ladderResult = new LadderResult();
        ladderResult.put(1, 2);
        ladderResult.put(3, 4);
        ladderResult.put(6, 8);
        assertThat(ladderResult.getTarget(1)).isEqualTo(2);
        assertThat(ladderResult.getTarget(3)).isEqualTo(4);
        assertThat(ladderResult.getTarget(6)).isEqualTo(8);
    }
}
