package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import ladder.util.ExceptionMessageFormatter;

public class Players {

    public static final int MIN_PLAYER_COUNT = 2;

    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    private void validate(List<Player> players) {
        if (players.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.format("참가자는 " + MIN_PLAYER_COUNT + "명 이상이어야 합니다.", players.size()));
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
