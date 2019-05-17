package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Players {
    static int NUM_OF_PLAYERS;

    private final List<Player> players;

    public Players(List<Player> players) {
        validateNotNull(players);
        validateNumOfPlayers(players);
        this.players = players;
    }

    private void validateNotNull(List<Player> players) {
        if (players == null || players.contains(null)) {
            throw new IllegalArgumentException("플레이어 리스트가 null 입니다.");
        }
    }

    private void validateNumOfPlayers(List<Player> players) {
        if (players.size() != NUM_OF_PLAYERS) {
            throw new IllegalArgumentException("플레이어 수가 적절하지 않습니다.");
        }
    }

    public Players goDown(Line line) {
        List<Player> movedPlayers = new ArrayList<>();

        for (Player player : players) {
            movedPlayers.add(player.moveOn(line));
        }
        return new Players(movedPlayers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        return "Players{" +
                "players=" + players +
                '}';
    }
}
