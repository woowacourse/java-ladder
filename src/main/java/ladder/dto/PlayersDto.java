package ladder.dto;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

public record PlayersDto(List<String> playerNames) {

    public static PlayersDto from(final Players players) {
        final List<Player> playerNames = players.getPlayers();

        return playerNames.stream()
                .map(Player::getName)
                .collect(Collectors.collectingAndThen(Collectors.toList(), PlayersDto::new));
    }
}
