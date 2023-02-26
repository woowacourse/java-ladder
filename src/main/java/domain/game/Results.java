package domain.game;

import domain.info.Name;
import domain.info.Reward;
import java.util.HashMap;
import java.util.Map;

public class Results {
    private final Map<Name, Reward> results = new HashMap<>();

    public void putResult(final Name name, final Reward reward) {
        results.put(name, reward);
    }

    public Reward getReward(final Name name) {
        return results.get(name);
    }
}
