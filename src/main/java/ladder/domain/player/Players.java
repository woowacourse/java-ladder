package ladder.domain.player;

import java.util.*;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(String[] playerNames) {
        checkEmptyPlayers(playerNames);
        players = Arrays.stream(playerNames)
                .map(name -> new Player(name.trim()))
                .collect(Collectors.toList());
        checkDuplicatePlayer(playerNames);
    }

    private void checkEmptyPlayers(String[] playerNames) {
        if (playerNames == null || playerNames.length == 0) {
            throw new IllegalArgumentException("Player 가 1명 이상 존재해야 합니다.");
        }
    }

    private void checkDuplicatePlayer(String[] playerNames) {
        if (new HashSet<>(players).size() != playerNames.length) {
            throw new IllegalArgumentException("중복되는 이름의 Player 가 있습니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public Player get(int index) {
        return players.get(index);
    }

    public boolean contains(String playerName) {
        return players.contains(new Player(playerName));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    @Override
    public String toString() {
        return players.toString();
    }
}
