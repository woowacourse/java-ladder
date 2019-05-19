package ladder.domain.generator;

import ladder.domain.Rewards;

import java.util.HashMap;
import java.util.Map;

public final class RewardsGenerator {
    private static final String DELIMITER = ",";

    private final String input;

    public RewardsGenerator(String input) {
        this.input = input;
    }

    public Rewards generate() {
        Map<Integer, String> map = new HashMap<>();
        int index = 0;
        for (String in : input.split(DELIMITER)) {
            map.put(index++, in.trim());
        }
        return new Rewards(map);
    }
}
