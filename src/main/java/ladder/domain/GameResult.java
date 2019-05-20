package ladder.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {
    private final Map<Player, Reward> results;

    public GameResult(Ladder ladder, GamePlayers gamePlayers, PlayerRewards playerRewards) {
        this.results = new LinkedHashMap<>();
        validate(gamePlayers.size(), playerRewards.size());
        for (int i = 0; i < gamePlayers.size(); i++) {
            int result = ladder.moveLadder(i);
            results.put(gamePlayers.getPlayer(i), playerRewards.getReward(result));
        }
    }

    private void validate(int countOfPlayers, int countOfRewards) {
        if (countOfPlayers != countOfRewards) {
            throw new IllegalArgumentException("사용자의 수와 당첨보상의 수가 다릅니다.");
        }
    }

    public Reward get(Player player) {
        return results.get(player);
    }

    public Map<Player, Reward> getAllResults() {
        return new HashMap<>(results);
    }
}
