package ladder.domain.reward;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {

    private final Map<Player, Reward> gameResult = new HashMap<>();

    private GameResult() {

    }

    public static GameResult create(Players players, Ladder ladder, Rewards rewards) {
        GameResult createdGameResult = new GameResult();

        List<Player> totalPlayers = players.getPlayers();
        for (int playerIndex = 0; playerIndex < totalPlayers.size(); playerIndex++) {
            int rewardIndex = ladder.findLadderResult(playerIndex);
            createdGameResult.gameResult.put(totalPlayers.get(playerIndex), rewards.findRewardByIndex(rewardIndex));
        }

        return createdGameResult;
    }

    public Map<Player, Reward> findResultByPlayers(Players players) {
        Map<Player, Reward> result = new HashMap<>();

        List<Player> targetPlayers = players.getPlayers();
        for (Player targetPlayer : targetPlayers) {
            result.put(targetPlayer, gameResult.get(targetPlayer));
        }

        return result;
    }

}
