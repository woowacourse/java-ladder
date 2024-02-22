package domain;

import java.util.List;

public class Players {

    private static final int MINIMUM_PLAYER_SIZE = 2;
    private static final int MAXIMUM_PLAYER_SIZE = 10;

    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    private void validate(List<Player> players) {
        if (players.size() < MINIMUM_PLAYER_SIZE || players.size() > MAXIMUM_PLAYER_SIZE) {
            throw new IllegalArgumentException(String.format("2명 이상, 10명 이하인 인원만 입력해주세요. 입력한 인원 : %d", players.size()));
        }
    }

    public int getSize() {
        return this.players.size();
    }
}
