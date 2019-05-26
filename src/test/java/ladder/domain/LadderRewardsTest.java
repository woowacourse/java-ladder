package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRewardsTest {
    @Test
    void 출력() {
        LadderRewards ladderRewards = new LadderRewards(Arrays.asList("꽝", "5000"));
        assertThat(ladderRewards.toString()).isEqualTo("     꽝  5000");
    }
}
