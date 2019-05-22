package ladder.domain;

import java.util.*;

public class PlayerGroup {
    private Set<Player> players = new LinkedHashSet<>();

    public PlayerGroup(List<String> playerNames) {
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
        checkDuplication(players.size(), playerNames.size());
    }

    private void checkDuplication(int numberOfUniqueNames, int numberOfPlayer) {
        if (numberOfUniqueNames != numberOfPlayer) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public Player getPlayerAtPositionOf(int position) {
        List<Player> players = new ArrayList<>(this.players);

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
