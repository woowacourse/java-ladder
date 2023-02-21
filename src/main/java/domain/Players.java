package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Players {
    private List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player findByName(String readPlayer) {
        return players.stream()
                .filter(player -> Objects.equals(player.getName(), new Name(readPlayer)))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 플레이어가 없습니다."));
    }

}
