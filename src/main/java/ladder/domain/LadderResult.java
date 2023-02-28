package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Reward;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    private final Map<Player, Reward> result = new LinkedHashMap<>();

    public LadderResult(Players players, Ladder ladder) {
        for (Player player : players.getPlayers()) {
            Reward reward = ladder.getItemOfPlayer(player);
            this.result.put(player, reward);
        }
    }

    public Reward getItemOfPlayer(Player player) {
        validateNotExistPlayer(player);
        validateNullItem(player);
        return result.get(player);
    }

    private void validateNotExistPlayer(Player player) {
        if (!result.containsKey(player)) {
            throw new IllegalStateException("플레이어가 존재하지 않습니다.");
        }
    }

    private void validateNullItem(Player player) {
        if (result.get(player) == null) {
            throw new IllegalStateException("플레이어의 결과가 존재하지 않습니다.");
        }
    }

    public Map<Player, Reward> getResult() {
        return result;
    }
}
