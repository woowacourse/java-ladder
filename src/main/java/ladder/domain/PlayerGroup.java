package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerGroup {
    private static final int MINIMUM_NUMBER_OF_PLAYER = 2;

    private List<Player> players = new LinkedList<>();

    public PlayerGroup(List<String> playerNames) {
        checkDuplicationIn(playerNames);
        validateNumberOfPlayers(playerNames.size());
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
    }

    private void checkDuplicationIn(List<String> playerNames) {
        Set playerNameSet = playerNames.stream()
                .map(String::trim)
                .collect(Collectors.toSet());

        if (playerNameSet.size() != playerNames.size()) {
            throw new IllegalArgumentException("중복되는 이름은 입력할 수 없습니다.");
        }
    }

    private void validateNumberOfPlayers(int numberOfPlayers) {
        if (numberOfPlayers < MINIMUM_NUMBER_OF_PLAYER) {
            throw new IllegalArgumentException("플레이어 수는 2 이상이어야 합니다.");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayerAtPositionOf(int position) {
        return players.get(position);
    }

    public int size() {
        return players.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerGroup that = (PlayerGroup) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
