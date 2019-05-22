package ladderGame.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {
    private final Map<UserName, Reward> resultMap;

    public LadderGameResult(List<Reward> rewards, List<User> users) {
        this.resultMap = createResultMap(rewards, users);
    }

    private Map<UserName, Reward> createResultMap(List<Reward> result, List<User> users) {
        Map<UserName, Reward> resultMap = new HashMap<>();

        for (User user : users) {
            Reward reward = result.get(user.getPosition());
            resultMap.put(user.getName(), reward);
        }

        return resultMap;
    }

    public Reward getResultByName(String name) {
        return resultMap.get(new UserName(name));
    }

    public Map<UserName, Reward> getResultMap() {
        return resultMap;
    }
}
