package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private final Map<String, String> results;

    public GameResult(Ladder ladder, GamePlayers gamePlayers, PlayerRewards playerRewards) {
        this.results = new HashMap<>();
        validate(gamePlayers.size(), playerRewards.size());
        for (int i = 0; i < gamePlayers.size(); i++) {
            int result = ladder.moveLadder(i);
            results.put(gamePlayers.getPlayerName(i), playerRewards.getReward(result));
        }
    }

    private void validate(int countOfPlayers, int countOfRewards) {
        if (countOfPlayers != countOfRewards) {
            throw new IllegalArgumentException("사용자의 수와 당첨보상의 수가 다릅니다.");
        }
    }

    public String get(String playerName) {
        return results.get(playerName);
    }

    public Map<String, String> getAll() {
        return new HashMap<>(results);
    }
}
