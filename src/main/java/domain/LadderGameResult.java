package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {

    private final Map<User, Result> ladderGameResult;

    public LadderGameResult(final Map<User, Result> ladderGameResult) {
        this.ladderGameResult = Map.copyOf(ladderGameResult);
    }

    public LadderGameResult(final User user, final Result result) {
        ladderGameResult = new HashMap<>();
        ladderGameResult.put(user, result);
    }

    public Result findByUser(final User user) {
        return ladderGameResult.get(user);
    }

    public Map<User, Result> getLadderGameResult() {
        return ladderGameResult;
    }
}
