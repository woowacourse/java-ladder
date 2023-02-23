package domain.model;

import domain.vo.Name;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Integer> getPlayersPosition(Name name) {
        return players.stream()
                .filter(player -> player.getName().equals(name.get()))
                .map(player -> player.getPosition())
                .collect(Collectors.toList());
    }

    public List<Name> getPlayersName() {
        return players.stream()
                .map(player -> new Name(player.getName()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int size() {
        return players.size();
    }
}