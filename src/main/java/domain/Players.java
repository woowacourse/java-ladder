package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(PlayerNames playerNames) {
        players = new ArrayList<>();

        createPlayers(playerNames);
    }

    private void createPlayers(PlayerNames playerNames) {
        for (PlayerName playerName : playerNames.getPlayerNames()) {
            this.players.add(new Player(playerName.getName()));
        }
    }

    public List<String> getPlayersName() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int getPlayersSize() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
