package domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 20.
 */
public class Players {

    private List<Player> players;

    public Players(List<String> names) {
        validatePlayerCount(names);
//        this.players = createPlayer();
    }

    public List<Player> getPlayers() {
        return players;
    }

    private static void validatePlayerCount(List<String> names) {
        if (names.size() <= 1) {
            throw new IllegalArgumentException("사다리 게임의 최소 참가자 수는 2명 이상이어야 합니다.");
        }
    }
}
