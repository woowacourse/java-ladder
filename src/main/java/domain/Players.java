package domain;

import domain.validator.PlayersValidator;

import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        PlayersValidator playersValidator = new PlayersValidator();
        playersValidator.checkPlayers(players);
        this.players = players;
    }

    public int getMaxPlayerNameLength() {
        return players.stream()
                .mapToInt(player -> player.getPlayerName().getNameSize())
                .max()
                .orElseThrow();
    }

    public int getPlayersCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
