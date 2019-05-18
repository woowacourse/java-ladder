package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(String[] playerNames) {
        checkPlayers(playerNames);
        players = Arrays.stream(playerNames)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private void checkPlayers(String[] playerNames) {
        if (playerNames == null || playerNames.length == 0) {
            throw new IllegalArgumentException("Player 가 1명 이상 존재해야 합니다.");
        }
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
