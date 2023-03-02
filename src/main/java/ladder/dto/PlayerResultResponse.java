package ladder.dto;

import ladder.domain.PlayerResult;

public class PlayerResultResponse {
    private final String playerName;
    private final String playerPrize;

    public PlayerResultResponse(String playerName, String playerPrize) {
        this.playerName = playerName;
        this.playerPrize = playerPrize;
    }

    public static PlayerResultResponse of(PlayerResult playerResult) {
        return new PlayerResultResponse(playerResult.getPlayerName(), playerResult.getPrize());
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerPrize() {
        return playerPrize;
    }
}
