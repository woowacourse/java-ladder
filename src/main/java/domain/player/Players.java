package domain.player;

import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(Names names) {
        this.players = names.getValue()
                            .stream()
                            .map(Player::new)
                            .toList();
    }

    public Player searchPlayer(Name targetPlayerName) {
        return players.stream()
                      .filter(player -> player.name()
                                              .equals(targetPlayerName))
                      .findFirst()
                      .orElse(null);
    }

    public List<Name> getPlayerNames() {
        return players.stream()
                      .map(Player::name)
                      .toList();
    }

    public int getPlayerCount() {
        return players.size();
    }

}
