package ladder.domain.player;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Players {
    private static final int MAXIMUM_PLAYER_SIZE = 10;
    private static final int MINIMUM_PLAYER_SIZE = 2;
    private final List<Player> players;


    public Players(List<String> playerNames) {
        validatePlayers(playerNames);
        this.players = createPlayers(playerNames);
    }

    private static List<Player> createPlayers(List<String> playerNames) {
        return playerNames.stream()
                .map(Player::new)
                .toList();
    }

    private void validatePlayers(List<String> playerNames) {
        validateSize(playerNames);
        validateDuplicatedName(playerNames);
    }

    private void validateSize(List<String> playerNames) {
        int playerSize = playerNames.size();

        if (playerSize > MAXIMUM_PLAYER_SIZE || playerSize < MINIMUM_PLAYER_SIZE) {
            throw new IllegalArgumentException(
                    String.format("참가자들의 수는 %d~%d여야 합니다.", MINIMUM_PLAYER_SIZE, MAXIMUM_PLAYER_SIZE));
        }
    }

    private void validateDuplicatedName(List<String> playerNames) {
        if (playerNames.size() != new HashSet<>(playerNames).size()) {
            throw new IllegalArgumentException("참가자들의 이름은 중복될 수 없습니다.");
        }
    }


    public int countPlayers() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
