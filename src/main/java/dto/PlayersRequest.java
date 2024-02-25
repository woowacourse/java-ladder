package dto;

import domain.Players;

import java.util.List;

public record PlayersRequest(List<String> players) {
    public Players toPlayers() {
        return Players.from(players);
    }
}
