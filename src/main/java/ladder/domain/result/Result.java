package ladder.domain.result;

import ladder.domain.position.Positions;
import ladder.domain.prize.Prizes;
import ladder.domain.user.Users;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private final Map<String, String> result;

    public Result(Users users, Prizes prizes, Positions positions) {
        this.result = createResult();
    }

    private Map<String, String> createResult() {
        Map<String, String> result = new HashMap<>();
        return result;
    }

    public String getPrizeByUser(String userName) {
        return userName;
    }
}
