package domain.model;

import domain.vo.Name;

import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = List.copyOf(players);
        initPosition();
    }

    public void initPosition() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).initPosition(i);
        }
    }

    public void moveAll(Ladder ladder) {
        players.forEach(player -> player.move(ladder));
    }

    public int orderByName(Name name) {
        Player player = findByName(name);
        return player.getXPosition();
    }

    public Player findByName(Name name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

}
