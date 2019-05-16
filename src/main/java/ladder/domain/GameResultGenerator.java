package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public final class GameResultGenerator {
    private static final String DELIMITER = ",";

    private final String input;

    public GameResultGenerator(String input) {
        this.input = input;
    }

    public GameResult generate() {
        Map<Integer, String> map = new HashMap<>();
        int index = 0;
        for (String in : input.split(DELIMITER)) {
            map.put(index++, in.trim());
        }

        return new GameResult(map);
    }
}
