package laddergame.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(List<String> playerNames) {
        List<Player> tempPlayers = playerNames.stream()
                .map(name -> new Player(name))
                .collect(Collectors.toUnmodifiableList());
        validatePlayerNames(tempPlayers);
        this.players = List.copyOf(tempPlayers);
    }

    private void validatePlayerNames(List<Player> tempPlayers) {
        Set<Player> nameSet = new HashSet<>(tempPlayers);
        if (nameSet.size() != tempPlayers.size()) {
            throw new IllegalArgumentException("[ERROR] 플레이어 이름이 중복되었습니다.");
        }

        if (tempPlayers.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 2명 이상의 플레이어가 필요합니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(player -> player.getName())
                .collect(Collectors.toList());
    }
}
