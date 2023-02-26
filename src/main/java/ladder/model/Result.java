package ladder.model;

import java.util.Collections;
import java.util.Map;

import static ladder.model.ErrorMessage.EXCEPTION_RESULT_NOT_FOUND;

public class Result {

    private Map<Player, Reward> result;

    public Result(Map<Player, Reward> result) {
        this.result = result;
    }

    public Reward getRewardFor(String askedPlayerName) {
        Player askedPlayer = result.keySet().stream()
                .filter(key -> key.isSameName(askedPlayerName))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(EXCEPTION_RESULT_NOT_FOUND.getMessage()));

        return result.get(askedPlayer);
    }

    public Map<Player, Reward> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
