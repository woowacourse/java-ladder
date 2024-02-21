package ladder.dto.request;

import java.util.List;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.util.InputUtils;

public record PlayerNamesRequest(String input) {
    public Players toPlayers() {
        List<Player> players = InputUtils.splitByComma(input).stream()
                .map(Player::new)
                .toList();

        return new Players(players);
    }
}
