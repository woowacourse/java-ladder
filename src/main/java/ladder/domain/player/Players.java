package ladder.domain.player;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Players {
    private static final int MAXIMUM_PLAYER_SIZE = 10;
    private static final int MINIMUM_PLAYER_SIZE = 2;

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<String> playerNames) {
        validate(playerNames);

        List<Player> players = playerNames.stream()
                .map(Player::new)
                .toList();

        return new Players(players);
    }

    private static void validate(List<String> playerNames) {
        validateSize(playerNames);
        validateDuplicatedName(playerNames);
    }

    private static void validateSize(List<String> playerNames) {
        int size = playerNames.size();

        if (MAXIMUM_PLAYER_SIZE < size || size < MINIMUM_PLAYER_SIZE) {
            throw new IllegalArgumentException(
                    String.format("참가자들의 수는 %d~%d여야 합니다.", MINIMUM_PLAYER_SIZE, MAXIMUM_PLAYER_SIZE));
        }
    }

    private static void validateDuplicatedName(List<String> playerNames) {

        if (playerNames.size() != new HashSet<>(playerNames).size()) {
            throw new IllegalArgumentException("참가자들의 이름은 중복될 수 없습니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
