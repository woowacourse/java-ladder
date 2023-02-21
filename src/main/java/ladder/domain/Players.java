package ladder.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 13;

    private final List<Player> players;

    public Players(String[] names) {
        validateSize(names);
        validateDuplicate(names);
        this.players = Arrays.stream(names)
                .map(Player::new)
                .collect(toList());
    }

    public void validateSize(String[] names) {
        if (isProper(names)) {
            throw new IllegalArgumentException("[ERROR] 사용자는 2명에서 13명까지 가능합니다.");
        }
    }

    private boolean isProper(String[] names) {
        return MAX_PLAYERS < names.length || names.length < MIN_PLAYERS;
    }

    private void validateDuplicate(String[] names) {
        long uniqueNamesLength = Arrays.stream(names)
                .distinct()
                .count();
        if (uniqueNamesLength != names.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다.");
        }
    }

    public String asString() {
        return players.stream()
                .map(Player::getName)
                .map(name -> String.format("%-5s", name))
                .collect(Collectors.joining(" "));
    }

    public int getPlayersCount() {
        return players.size();
    }
}
