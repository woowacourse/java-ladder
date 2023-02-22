package ladder.dto;

import ladder.domain.User;

import java.util.HashMap;
import java.util.Map;

public class BridgeGameResult {
    private final Map<User, String> userAndReward = new HashMap<>();

    public void enrollReward(User user, String reward) {
        userAndReward.put(user, reward);
    }

    public Map<User, String> getUserAndReward() {
        return new HashMap<>(userAndReward);
    }

}
