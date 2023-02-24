package domain.model;

import domain.vo.Name;

import java.util.List;

public class Players {

    private static final String NO_PLAYER_ERROR_MESSAGE = "해당 이름의 플레이어는 존재하지 않습니다.";

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
                .orElseThrow(() -> new IllegalArgumentException(NO_PLAYER_ERROR_MESSAGE));
    }

}
