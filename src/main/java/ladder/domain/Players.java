package ladder.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {
    private static final int MINIMUM_LENGTH_OF_PLAYERS = 2;

    private final List<Player> players;

    public Players(String[] playerNames) {
        validateSize(playerNames);
        this.players = Arrays.stream(playerNames)
                .map(name -> new Player(name.trim()))
                .collect(Collectors.toList());
        validateDuplication(players);
    }

    private void validateSize(String[] playerNames) {
        if (playerNames.length < MINIMUM_LENGTH_OF_PLAYERS) {
            throw new IllegalArgumentException("2명 이상의 이름을 제대로 입력해 주세요.");
        }
    }

    private void validateDuplication(List<Player> players) {
        Set<Player> nonDuplicatedPlayers = new HashSet<>(players);
        if (nonDuplicatedPlayers.size() != players.size()) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    public boolean hasSameSize(int size) {
        return players.size() == size;
    }

    public boolean contains(Player player) {
        return players.contains(player);
    }

    public int indexOf(Player player) {
        return players.indexOf(player);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int getSize() {
        return players.size();
    }
}
