package ladder.domain;

import java.util.*;

public class PlayerGroup {
    private Set<Player> players = new LinkedHashSet<>();

    public PlayerGroup(List<String> playerNames) {
        for (int i = 0; i < playerNames.size(); i++) {
            players.add(new Player(playerNames.get(i), i));
        }
        checkDuplication(players.size(), playerNames.size());
    }

    private void checkDuplication(int numberOfUniqueNames, int numberOfPlayer) {
        if (numberOfUniqueNames != numberOfPlayer) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public void changePositionBy(Crosspoints crosspoints) {
        for (Player player : players) {
            player.stepDown(crosspoints);
        }
    }

    public Set<Player> getPlayers() {
        return players;
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
