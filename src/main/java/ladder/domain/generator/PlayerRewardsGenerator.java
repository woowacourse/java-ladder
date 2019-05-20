package ladder.domain.generator;

import ladder.domain.PlayerRewards;
import ladder.domain.Reward;

import java.util.HashMap;
import java.util.Map;

public final class PlayerRewardsGenerator {
    private static final String DELIMITER = ",";

    private final String input;

    public PlayerRewardsGenerator(String input) {
        this.input = input;
    }

    public PlayerRewards generate() {
        Map<Integer, Reward> map = new HashMap<>();
        int index = 0;
        for (String in : input.split(DELIMITER)) {
            Reward reward = new Reward(in.trim());
            map.put(index++, reward);
        }

        return new PlayerRewards(map);
    }
}
