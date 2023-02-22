package domain;

import java.util.Collections;
import java.util.List;

public class Players {

    public static final int MINIMUM_NUMBER_OF_PLAYERS = 2;

    private final List<Player> players;

    public Players(List<Player> players) throws IllegalArgumentException {
        validateMoreThanOnePlayer(players);
        this.players = players;
    }

    private void validateMoreThanOnePlayer(List<Player> players) {
        if (players.size() < MINIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("[ERROR] 플레이어는 두 명 이상 입력해야 합니다.");
        }
    }

    public int getNumberOfPlayers() {
        return this.players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }
}
