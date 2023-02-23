package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Name, Reward> results = new HashMap<>();

    public Result(List<Name> names, List<Integer> results, List<Reward> rewards) {
        mapResults(names, results, rewards);
    }

    private void mapResults(List<Name> names, List<Integer> results, List<Reward> rewards) {
        for (int i = 0; i < names.size(); i++) {
            Name name = names.get(i);
            Reward reward = rewards.get(results.get(i));
            this.results.put(name, reward);
        }
    }

    public Reward getReward(Name name) {
        return results.get(name);
    }
}
