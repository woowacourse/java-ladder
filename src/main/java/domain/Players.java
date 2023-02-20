package domain;

import laddervalidate.PlayerNameValidator;

import java.util.List;

public class Players {
    private final List<String> players;

    public Players(List<String> players) {
        PlayerNameValidator playerNameValidator = new PlayerNameValidator();
        playerNameValidator.validate(players);
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
