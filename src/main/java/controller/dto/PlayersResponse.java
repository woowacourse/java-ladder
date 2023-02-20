package controller.dto;

import domain.Player;
import domain.Players;

import java.util.List;

public class PlayersResponse {

    private final List<String> playerNames;

    private PlayersResponse(List<String> playerNames) {
        this.playerNames = playerNames;
    }

    public static PlayersResponse from(Players players) {
        List<String> playerNames = players.getPlayerNames();
        return new PlayersResponse(playerNames);
    }

    public List<String> getPlayers() {
        return playerNames;
    }
}
