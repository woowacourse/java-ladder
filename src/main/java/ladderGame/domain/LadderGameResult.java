package ladderGame.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {
    private final Map<UserName, Reward> resultMap;

    public LadderGameResult(List<String> result, List<User> users) {
        this.resultMap = createResultMap(result, users);
    }

    private Map<UserName, Reward> createResultMap(List<String> result, List<User> users) {
        Map<UserName, Reward> resultMap = new HashMap<>();

        for (User user : users) {
            UserName userName = new UserName(user.getName());
            Reward reward = new Reward(result.get(user.getPosition()));
            resultMap.put(userName, reward);
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
