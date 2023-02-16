package domain;

import laddervalidate.PlayerNameValidator;

import java.util.List;

public class Players {
    PlayerNameValidator playerNameValidator = new PlayerNameValidator();
    private final List<String> players;

    public Players(List<String> players) {
        playerNameValidator.checkPlayerCount(players);
        playerNameValidator.checkPlayerNameLength(players);
        playerNameValidator.checkDuplicatePlayers(players);
        this.players = players;
    }

    public int getMaxPlayerNameLength() {
        return players.stream().mapToInt(String::length).max().orElse(0);
    }

    public int getPlayersCount() {
        return players.size();
    }

    public List<String> getPlayers() {
        return players;
    }


}
