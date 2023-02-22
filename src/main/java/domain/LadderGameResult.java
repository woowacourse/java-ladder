package domain;

import java.util.Map;

public class LadderGameResult {

    Map<User, Result> ladderGameResult;

    public LadderGameResult(final Map<User, Result> ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public Result findByUser(User user) {
        return ladderGameResult.get(user);
    }
}
