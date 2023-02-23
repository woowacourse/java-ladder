package controller.dto;

import domain.LadderGameResult;
import domain.players.Player;
import domain.prize.Prize;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class TotalResultResponse {

    private final Map<String, String> playerToPrize;

    private TotalResultResponse(final Map<String, String> playerToPrize) {
        this.playerToPrize = new LinkedHashMap<>(playerToPrize);
    }

    public static TotalResultResponse from(LadderGameResult ladderGameResult) {
        Map<Player, Prize> result = ladderGameResult.getResult();
        Map<String, String> playerToResult = new LinkedHashMap<>();
        result.forEach((player, prize) -> playerToResult.put(player.getName(), prize.getValue()));
        return new TotalResultResponse(Collections.unmodifiableMap(playerToResult));
    }

    public Map<String, String> getPlayerToPrize() {
        return playerToPrize;
    }

}
