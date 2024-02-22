package domain;

import java.util.List;

class Players {

    private final List<Player> players;

    public Players(List<String> names) {
        this.players = mapToPlayer(names);
    }

    public List<Player> mapToPlayer(List<String> names) {
        return names.stream()
                .map(name -> new Player(name.trim()))
                .toList();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
