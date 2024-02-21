package dto;

import domain.Players;

import java.util.List;

public class PlayersRequest {
    private final List<String> players;

    public PlayersRequest(List<String> players) {
        this.players = players;
    }

    public Players toPlayers() {
        return new Players(players);
    }
}
