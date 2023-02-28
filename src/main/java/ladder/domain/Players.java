package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public boolean contains(final String playerName) {
        return players.stream()
                .anyMatch(player -> player.getName().equals(playerName));
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }
}
