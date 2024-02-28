package domain.player;

import domain.common.Name;

import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(final List<Player> players) {
        this.players = players;
    }

    public Players(Names names) {
        this.players = names.getValue()
                            .stream()
                            .map(Player::new)
                            .toList();
    }

    public List<Name> getPlayerNames() {
        return players.stream()
                      .map(Player::getName)
                      .toList();
    }

    public int getPlayerIndex(Player player) {
        return players.indexOf(player);
    }

    public Player getPlayerWithName(Name name) {
        return players.stream()
                      .filter(player -> player.isNameEqual(name))
                      .findFirst()
                      .orElseThrow(() -> new IllegalArgumentException("없는 플레이어입니다."));
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
