package ladder.dto;

import static java.util.stream.Collectors.*;

import java.util.List;
import ladder.domain.PlayerResults;

public class PlayerResultResponse {
    private final String playerName;
    private final String playerPrize;

    public PlayerResultResponse(String playerName, String playerPrize) {
        this.playerName = playerName;
        this.playerPrize = playerPrize;
    }

    public static List<PlayerResultResponse> of(PlayerResults playerResults) {
        return playerResults.getPlayerResults().stream()
                .map(playerResult -> new PlayerResultResponse(playerResult.getPlayerName(), playerResult.getPrize()))
                .collect(toList());
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerPrize() {
        return playerPrize;
    }
}
