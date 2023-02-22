package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResultTable {
    private final Map<User, Reward> resultTable = new LinkedHashMap<>();

    public void initialize(User user) {
        resultTable.put(user, null);
    }

    public Reward getRewardByUser(User user) {
        return resultTable.get(user);
    }

    public void save(User user, Reward resultReward) {
        resultTable.put(user, resultReward);
    }
}
