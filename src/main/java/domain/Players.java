package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;

    private final List<Player> players;

    private Players(List<Player> players) {

        validateNumberOfPlayers(players);
        this.players = players;
    }

    public static Players of(String[] names) {
        List<Player> players = Arrays.stream(names)
                .map(Player::new)
                .collect(Collectors.toList());

        return new Players(players);
    }

    private void validateNumberOfPlayers(List<Player> players) {
        if (players.size() < MINIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("[ERROR] 두 명 이상 입력해야 합니다.");
        }
    }

    public int getNumberOfPlayers() {
        return this.players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
