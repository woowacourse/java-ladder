package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ladder.util.NotNullValidator.validateNotNull;

public class Players {
    static int MIN_NUM_OF_PLAYERS = 2;
    public static int NUM_OF_PLAYERS;

    private final List<Player> players;

    public Players(List<Player> players) {
        validateNotNull(players);
        validateNumOfPlayers(players);
        this.players = players;
    }

    private void validateNumOfPlayers(List<Player> players) {
        if (players.size() != NUM_OF_PLAYERS || NUM_OF_PLAYERS < MIN_NUM_OF_PLAYERS) {
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

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public List<PlayerName> getPlayerNames() {
        List<PlayerName> names = new ArrayList<>();
        for (Player player : players) {
            names.add(player.getName());
        }
        return names;
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
