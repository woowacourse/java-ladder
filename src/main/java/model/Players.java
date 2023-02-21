package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players = new ArrayList<>();

    public Players(List<Name> names) {
        names.stream()
                .map(Player::new)
                .forEach(players::add);
    }

    public int size() {
        return players.size();
    }

    public List<String> getAllPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public Player findPlayerByName(Name name) {
        return players.stream()
                .filter(player -> player.isPlayerName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
