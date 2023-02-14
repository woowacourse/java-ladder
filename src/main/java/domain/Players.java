package domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Players {
    private static final String DELIMITER = ",";

    private final List<Player> players;

    public Players(String input) {
        String[] names = input.split(DELIMITER);
        validateSize(names);
        validateDuplicate(names);
        this.players = Arrays.stream(names)
                .map(Player::new)
                .collect(toList());
    }

    public void validateSize(String[] names) {
        if (names.length < 2 || names.length > 13) {
            throw new IllegalArgumentException("[ERROR] 사용자는 2명에서 13명까지 가능합니다.");
        }
    }

    private void validateDuplicate(String[] names) {
        long uniqueNamesLength = Arrays.stream(names)
                .distinct()
                .count();
        if (uniqueNamesLength != names.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다.");
        }
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
