package ladder.domain.player;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.player.Player;
import ladder.exception.NotFoundPlayerException;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public Player findByPlayerName(String playerName) {
        return players.stream()
                .filter(player -> player.isSameName(playerName))
                .findFirst()
                .orElseThrow(NotFoundPlayerException::new);
    }

    public int getSize() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }
}
