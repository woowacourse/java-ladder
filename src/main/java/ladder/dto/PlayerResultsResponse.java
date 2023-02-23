package ladder.dto;

import static java.util.stream.Collectors.*;

import java.util.List;
import ladder.domain.PlayerResults;

public class PlayerResultsResponse {
    private final List<String> playerResults;

    public PlayerResultsResponse(List<String> playerResults) {
        this.playerResults = playerResults;
    }

    public static PlayerResultsResponse of(PlayerResults playerResults) {
        List<String> resultsStrings = playerResults.getPlayerResults().stream()
                .map(playerResult -> playerResult.getPlayerName() + " : " + playerResult.getPrize())
                .collect(toList());
        return new PlayerResultsResponse(resultsStrings);
    }

    public List<String> getPlayerResults() {
        return playerResults;
    }
}
