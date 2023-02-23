package ladder.dto;

import ladder.domain.User;

import java.util.HashMap;
import java.util.Map;

public class BridgeGameResult {
    private final Map<User, String> userAndReward;

    public BridgeGameResult(Map<User, String> rewardData) {
        this.userAndReward = rewardData;
    }

    public Map<User, String> getUserAndReward() {
        return new HashMap<>(userAndReward);
    }

}
