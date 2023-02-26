package ladder.domain.reward;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Name;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

import java.util.*;
import java.util.stream.Collectors;

public class GameResult {

    private static final String ALL_TARGET_PLAYERS = "all";

    private final Map<Player, Reward> gameResult = new LinkedHashMap<>();

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

    public Map<Player, Reward> findResultByPlayers(List<String> targetPlayerNames) {
        Map<Player, Reward> result = new HashMap<>();
        List<Player> targetPlayers = targetPlayerNamesToPlayers(targetPlayerNames);
        for (Player targetPlayer : targetPlayers) {
            validateDoesNotExistPlayers(targetPlayer);
            result.put(targetPlayer, gameResult.get(targetPlayer));
        }
        return result;
    }

    private List<Player> targetPlayerNamesToPlayers(List<String> targetPlayerNames) {
        if (targetPlayerNames.contains(ALL_TARGET_PLAYERS)) {
            return new ArrayList<>(gameResult.keySet());
        }
        return targetPlayerNames.stream()
                .map(targetPlayerName -> new Player(new Name(targetPlayerName)))
                .collect(Collectors.toList());
    }

    private void validateDoesNotExistPlayers(Player targetPlayer) {
        if (!gameResult.containsKey(targetPlayer)) {
            throw new IllegalArgumentException("플레이어 목록에 없는 이름입니다.");
        }
    }

}
