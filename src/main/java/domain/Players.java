package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(PlayerNames playerNames) {
        return new Players(playerNames.getPlayerNames()
                .stream()
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public int playerAmount() {
        return this.players.size();
    }

    public Player findByName(String playerName) {
        return this.players.stream()
                .filter(player -> player.getPlayerName().equals(playerName))
                .findFirst()
                .orElseThrow();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
