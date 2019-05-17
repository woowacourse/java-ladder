package ladder.domain.generator;

import ladder.domain.PlayerRewards;

import java.util.HashMap;
import java.util.Map;

public final class PlayerRewardsGenerator {
    private static final String DELIMITER = ",";

    private final String input;

    public  PlayerRewardsGenerator(String input) {
        this.input = input;
    }

    public PlayerRewards generate() {
        Map<Integer, String> map = new HashMap<>();
        int index = 0;
        for (String in : input.split(DELIMITER)) {
            map.put(index++, in.trim());
        }

        return new PlayerRewards(map);
    }
}
