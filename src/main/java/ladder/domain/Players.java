package ladder.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Players {
    private static final int PLAYERS_SIZE_LOWER_BOUND_INCLUSIVE = 2;
    private static final String PLAYERS_SIZE_ERROR_MESSAGE = "플레이어 사이즈는 2 이상이어야 합니다.";
    private static final String DUPLICATE_NAMES_ERROR_MESSAGE = "이름에 중복이 존재합니다";
    private final List<Player> players;

    private Players(List<Player> players) {
        validateSize(players);
        this.players = players;
    }

    public static Players from(List<String> names) {
        validateDuplication(names);
        return names.stream()
                    .map(Player::new)
                    .collect(collectingAndThen(toUnmodifiableList(), Players::new));
    }

    private static void validateDuplication(List<String> names) {
        Set<String> distinctNames = new HashSet<>(names);
        if (distinctNames.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAMES_ERROR_MESSAGE);
        }
    }

    private void validateSize(List<Player> players) {
        if (players.size() < PLAYERS_SIZE_LOWER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException(PLAYERS_SIZE_ERROR_MESSAGE);
        }
    }

    public int getPlayersSize() {
        return players.size();
    }


    public List<String> getNames() {
        return players.stream()
                      .map(Player::getName)
                      .collect(toUnmodifiableList());
    }
}
