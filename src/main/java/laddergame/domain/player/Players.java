package laddergame.domain.player;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Players {

    private final List<Player> players;

    public Players(final List<Player> players) {
        this.players = players;
    }

    public Player findPlayerByName(final String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 플레이어가 없습니다."));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Names findPlayerNames() {
        return new Names(players.stream()
                .map(Player::getName)
                .collect(toList()));
    }

    public int getPlayerSize() {
        return players.size();
    }
}
