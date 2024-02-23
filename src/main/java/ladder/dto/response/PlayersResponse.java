package ladder.dto.response;

import java.util.List;
import ladder.domain.player.Players;

public record PlayersResponse(List<PlayerResponse> playerResponses) {
    public static PlayersResponse from(Players players) {
        final List<PlayerResponse> playerResponses = players.getPlayers().stream()
                .map(PlayerResponse::from)
                .toList();

        return new PlayersResponse(playerResponses);
    }
}
