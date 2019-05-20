package ladder.domain;

import java.util.HashMap;
import java.util.Map;

import static ladder.util.NotNullValidator.validateNotNull;

public class QueryProcessor {
    private Results results;

    public QueryProcessor(Players playersAfterGame, Rewards rewards) {
        validateNotNull(playersAfterGame);
        validateNotNull(rewards);
        Map<PlayerName, Reward> resultPairs = new HashMap<>();
        for (int i=0; i<Players.NUM_OF_PLAYERS; i++) {
            Player thisPlayer = playersAfterGame.getPlayer(i);
            resultPairs.put(thisPlayer.getName(), rewards.getReward(thisPlayer.getPosition().getValue()));
        }
        results = new Results(resultPairs);
    }

    public Reward getRewardOf(PlayerName name) {
        return results.getRewardOf(name);
    }

    public Results getAll() {
        return results;
    }

    public Results getResults() {
        return results;
    }
}