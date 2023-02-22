package domain;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> players;

    public Players(List<String> names) {
        validatePlayerCount(names);
        this.players = createPlayer(names);
    }

    public List<Player> getPlayers() {
        return players;
    }

    private static void validatePlayerCount(List<String> names) {
        if (names.size() <= 1) {
            throw new IllegalArgumentException("사다리 게임의 최소 참가자 수는 2명 이상이어야 합니다.");
        }
    }

    private List<Player> createPlayer(List<String> names) {
        List<Player> playerList = new ArrayList<>();
        for (int position = 0; position < names.size(); position++) {
            playerList.add(new Player(names.get(position), position));
        }
        return playerList;
    }
}
