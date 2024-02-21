package domain;

import java.util.List;

public class Players {

    private static final int MINIMUM_PLAYER_COUNT = 2;
    private final List<Player> players;

    public Players(List<Player> players) {
        validatePlayerSize(players);
        this.players = players;
    }

    private static void validatePlayerSize(List<Player> players) {
        if(players.size() < MINIMUM_PLAYER_COUNT) {
            throw new IllegalArgumentException("[Error] 플레이어의 숫자는 2명 이상이어야 합니다.");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
