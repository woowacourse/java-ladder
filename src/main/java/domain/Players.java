package domain;

import java.util.Arrays;
import java.util.List;

class Players {

    private final List<Player> players;

    public Players(String input) {
        this.players = parsePlayerName(input);
    }

    public List<Player> parsePlayerName(String input) {
        return Arrays.stream(input.split(","))
                .map(name -> new Player(name.trim()))
                .toList();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
