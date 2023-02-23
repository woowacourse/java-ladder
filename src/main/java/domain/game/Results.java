package domain.game;

import domain.info.Name;
import domain.info.Names;
import domain.info.Reward;
import domain.info.Rewards;
import java.util.HashMap;
import java.util.Map;

public class Results {
    private final Map<Name, Reward> results;

    public Results(Names names, LadderGame ladderGame, Rewards rewards) {
        this.results = generateResults(names, ladderGame, rewards);
    }

    private Map<Name, Reward> generateResults(Names names, LadderGame ladderGame, Rewards rewards) {
        Map<Name, Reward> results = new HashMap<>();

        for (int i = 0; i < names.getNamesSize(); i++) {
            Name name = names.getName(i);
            int destination = ladderGame.getResult(i);
            Reward reward = rewards.getReward(destination);
            results.put(name, reward);
        }

        return results;
    }

    public Reward getReward(Name name) {
        return results.get(name);
    }
}
