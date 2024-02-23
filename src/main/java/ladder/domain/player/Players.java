package ladder.domain.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Players {
    public static final int MAXIMUM_PLAYER_SIZE = 10;
    public static final int MINIMUM_PLAYER_SIZE = 2;
    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = new ArrayList<>(players);
    }

    private void validate(List<Player> players) {
        validateSize(players);
        validateDuplicatedName(players);
    }

    private void validateSize(List<Player> players) {
        int playerSize = players.size();

        if (MAXIMUM_PLAYER_SIZE < playerSize || playerSize < MINIMUM_PLAYER_SIZE) {
            throw new IllegalArgumentException(
                    String.format("참가자들의 수는 %d~%d여야 합니다.", MINIMUM_PLAYER_SIZE, MAXIMUM_PLAYER_SIZE));
        }
    }

    private void validateDuplicatedName(List<Player> players) {
        List<String> playerNames = players.stream()
                .map(Player::getName)
                .toList();

        if (playerNames.size() != new HashSet<>(playerNames).size()) {
            throw new IllegalArgumentException("참가자들의 이름은 중복될 수 없습니다.");
        }
    }

    public int getSize() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
