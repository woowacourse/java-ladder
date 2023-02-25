package domain.game;

import domain.info.Info;
import domain.info.Name;
import domain.info.Reward;
import java.util.HashMap;
import java.util.Map;

public class Results {
    private final Map<Name, Reward> results;

    public Results(final Info info, final LadderGame ladderGame) {
        this.results = generateResults(info, ladderGame);
    }

    private static Map<Name, Reward> generateResults(final Info info, final LadderGame ladderGame) {
        Map<Name, Reward> results = new HashMap<>();

        for (int i = 0; i < info.getNamesSize(); i++) {
            Name name = info.getName(i);
            int destination = ladderGame.getResult(i);
            Reward reward = info.getReward(destination);
            results.put(name, reward);
        }

        return results;
    }

    public Reward getReward(final Name name) {
        return results.get(name);
    }
}
