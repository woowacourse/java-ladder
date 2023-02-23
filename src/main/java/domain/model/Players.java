package domain.model;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private final List<Player> players = new ArrayList<>();

    public void add(Player player) {
        players.add(player);
    }

    public void addAll(List<Player> players) {
        this.players.addAll(players);
    }

    public void moveAll(Ladder ladder) {
        players.forEach(player -> player.move(ladder));
    }

    public int orderByName(String name) {
        Player player = findByName(name);
        return player.getXPosition();
    }

    public Player findByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

}
