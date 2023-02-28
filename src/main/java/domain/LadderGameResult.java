package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {

    private final Map<User, Reward> ladderGameResult;

    public LadderGameResult(final Map<User, Reward> ladderGameResult) {
        this.ladderGameResult = Map.copyOf(ladderGameResult);
    }

    public LadderGameResult(final User user, final Reward reward) {
        ladderGameResult = new HashMap<>();
        ladderGameResult.put(user, reward);
    }

    public Reward findByUser(final User user) {
        return ladderGameResult.get(user);
    }

    public Map<User, Reward> getLadderGameResult() {
        return Collections.unmodifiableMap(ladderGameResult);
    }
}
