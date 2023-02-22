package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Name, Reward> result = new HashMap<>();

    public Result(Names names, List<Integer> results, Rewards rewards) {
        mapResults(names, results, rewards);
    }

    private void mapResults(Names names, List<Integer> results, Rewards rewards) {
        for (int i = 0; i < names.getPersonNumber(); i++) {
            Name name = names.getNames().get(i);
            Reward reward = rewards.getRewards().get(results.get(i));
            result.put(name, reward);
        }
    }

    public Reward getReward(Name name) {
        return result.get(name);
    }
}
