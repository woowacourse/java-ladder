package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameRewards {
    private static final String DEFALT_LENGTH_FORMAT = "%-6s";

    private List<Reward> rewards;

    public LadderGameRewards(List<String> rewards) {
        this.rewards = rewards.stream().map(Reward::new).collect(Collectors.toList());
    }

    Reward get(int i) {
        return rewards.get(i);
    }

    @Override
    public String toString() {
        return rewards.stream().map(drawResult -> String.format(DEFALT_LENGTH_FORMAT, drawResult.getResult())).collect(Collectors.joining());
    }
}
