package ladder.dto;

import static java.util.stream.Collectors.*;

import java.util.List;
import ladder.domain.Player;
import ladder.domain.Players;

public class PlayersResponse {
    private final List<String> playerNames;

    public PlayersResponse(List<String> playerNames) {
        this.playerNames = playerNames;
    }

    public static PlayersResponse ofPlayers(Players players) {
        return players.getPlayers().stream()
                .map(Player::getName)
                .collect(collectingAndThen(toList(), PlayersResponse::new));
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }
}
