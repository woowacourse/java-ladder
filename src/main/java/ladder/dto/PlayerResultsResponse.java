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
        return playerResults.getPlayerResults().stream()
                .map(playerResult -> playerResult.getPlayerName() + " : " + playerResult.getPrize())
                .collect(collectingAndThen(toList(), PlayerResultsResponse::new));
    }

    public List<String> getPlayerResults() {
        return playerResults;
    }
}
