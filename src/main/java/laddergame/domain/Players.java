package laddergame.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(List<String> playerNames) {
        validatePlayerNames(playerNames);
        this.players = playerNames.stream()
                .map(name -> new Player(name))
                .collect(Collectors.toUnmodifiableList());
    }

    private void validatePlayerNames(List<String> playerNames) {
        Set<String> nameSet = new HashSet<>(playerNames);
        if (nameSet.size() != playerNames.size()) {
            throw new IllegalArgumentException("[ERROR] 플레이어 이름이 중복되었습니다.");
        }

        if (playerNames.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 2명 이상의 플레이어가 필요합니다.");
        }
    }

    public int size() {
        return players.size();
    }
}
