package domain;

import domain.players.Player;
import domain.players.Players;
import domain.prize.Prize;
import domain.prize.Prizes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {

    private final Map<Player, Prize> result;

    private LadderGameResult(final Map<Player, Prize> result) {
        this.result = new HashMap<>(result);
    }

    public static LadderGameResult of(Players players, Prizes prizes, Map<Integer, Integer> ladderResult) {
        Map<Player, Prize> result = new HashMap<>();
        ladderResult.keySet().forEach((playerIndex) -> {
            Player player = players.getPlayerAt(playerIndex);
            Prize prize = prizes.getPrizeAt(ladderResult.get(playerIndex));
            result.put(player, prize);
        });
        return new LadderGameResult(Collections.unmodifiableMap(result));
    }

    public Map<Player, Prize> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
