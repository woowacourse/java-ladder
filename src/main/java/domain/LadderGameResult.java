package domain;

import domain.players.Player;
import domain.players.Players;
import domain.prize.Prize;
import domain.prize.Prizes;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGameResult {

    private final Map<Player, Prize> result;

    private LadderGameResult(final Map<Player, Prize> result) {
        this.result = new LinkedHashMap<>(result);
    }

    public static LadderGameResult of(Players players, Prizes prizes, Map<Integer, Integer> ladderResult) {
        Map<Player, Prize> playerToPrize = new LinkedHashMap<>();
        ladderResult.forEach((playerIndex, prizeIndex) ->
                playerToPrize.put(players.getPlayerAt(playerIndex), prizes.getPrizeAt(prizeIndex))
        );
        return new LadderGameResult(Collections.unmodifiableMap(playerToPrize));
    }

    public Map<Player, Prize> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public Prize getPersonalResult(final Player player) {
        return result.get(player);
    }

}
