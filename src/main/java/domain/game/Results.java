package domain.game;

import domain.info.Name;
import domain.info.Names;
import domain.info.Reward;
import domain.info.Rewards;
import java.util.HashMap;
import java.util.Map;

public class Results {
    private final Map<Name, Reward> results;

    public Results(final Names names, final LadderGame ladderGame, final Rewards rewards) {
        this.results = generateResults(names, ladderGame, rewards);
    }

    private static Map<Name, Reward> generateResults(final Names names,
                                                     final LadderGame ladderGame,
                                                     final Rewards rewards) {
        Map<Name, Reward> results = new HashMap<>();

        for (int i = 0; i < names.getNamesSize(); i++) {
            Name name = names.getName(i);
            int destination = ladderGame.getResult(i);
            Reward reward = rewards.getReward(destination);
            results.put(name, reward);
        }

        return results;
    }

    public Reward getReward(final Name name) {
        return results.get(name);
    }
}
