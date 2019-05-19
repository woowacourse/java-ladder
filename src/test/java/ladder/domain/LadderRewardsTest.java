package ladder.domain;

import org.junit.Test;

import java.util.Arrays;

public class LadderRewardsTest {
    @Test(expected = IllegalArgumentException.class)
    public void 생성_예외() {
        LadderRewards ladderRewards = new LadderRewards(Arrays.asList("a", "b", "c", "d"), 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_예외2() {
        LadderRewards ladderRewards = new LadderRewards(Arrays.asList("a", "b", "", "d"), 4);
    }
}