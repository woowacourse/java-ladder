package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;

    private final List<Player> players;

    public Players(String[] names) {
        validateMoreThanOnePlayer(names);
        this.players = createPlayer(names);
    }

    private void validateMoreThanOnePlayer(String[] names) {
        if (names.length < MINIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("[ERROR] 두 명 이상 입력해야 합니다.");
        }
    }

    private List<Player> createPlayer(String[] names) {
        return Arrays.stream(names)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int getNumberOfPlayers() {
        return this.players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
