package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {

    private final List<Player> players;

    public Players(final List<Player> players) {
        validateNumberOfPlayers(players);
        validateDuplicatedPlayers(players);
        this.players = players;
    }

    // TODO: 예외 메시지 작성
    private void validateNumberOfPlayers(final List<Player> players) {
        if (players.size() <= 1 || players.size() > 10) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedPlayers(final List<Player> players) {
        Set<String> nameWithoutDuplicated = new HashSet<>();

        for (Player player : players) {
            nameWithoutDuplicated.add(player.getName());
        }

        if (players.size() != nameWithoutDuplicated.size()) {
            throw new IllegalArgumentException();
        }
    }

    public int findLongestPlayerName() {
        return players.stream()
                .mapToInt(player -> player.getName().length())
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
