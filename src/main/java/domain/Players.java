package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Players {
    private final List<Player> players;

    Players(List<Player> players) {
        validateDuplicateName(players);
        validatePlayersCount(players);
        this.players = Collections.unmodifiableList(players);
    }

    private void validateDuplicateName(List<Player> players) {
        Set<Player> distinctPlayers = new HashSet<>(players);
        if (distinctPlayers.size() != players.size()) {
            throw new IllegalStateException("이름이 같은 참가자는 있을 수 없습니다.");
        }
    }

    private void validatePlayersCount(List<Player> players) {
        if (players == null || players.size() < 2 || players.size() > 10) {
            throw new IllegalStateException("참가자는 2명 이상 10명 이하여야 합니다.");
        }
    }

    static Players of(String... playerNames) {
        List<Player> players = Arrays.stream(playerNames).map(Player::new).toList();
        return new Players(players);
    }
}
