package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    public static final int MIN_PLAYER_COUNT = 2;

    private final List<Player> players;

    public Players(List<Player> players) {
        validatePlayers(players);
        this.players = players;
    }

    private void validatePlayers(List<Player> players) {
        if (players.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 합니다.");
        }
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int size() {
        return players.size();
    }
}
