package domain;

import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        if(players.size() <= 1) {
            throw new IllegalArgumentException("[Error] 플레이어의 숫자는 2명 이상이어야 합니다.");
        }
        this.players = players;
    }
}
