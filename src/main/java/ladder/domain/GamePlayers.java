package ladder.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GamePlayers {
    private final List<Player> players;

    public GamePlayers(final List<Player> players) {
        validate(players);
        this.players = new ArrayList<>(players);
    }

    private void validate(List<Player> players) {
        validateSize(players);
        validateDuplication(players);
    }

    private void validateSize(List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException("두 명 이상 입력 해주세요.");
        }
    }

    private void validateDuplication(List<Player> players) {
        Set<Player> set = new HashSet<>(players);
        if (set.size() != players.size()) {
            throw new IllegalArgumentException("이름 중복은 안됩니다.");
        }
    }

    public int index(String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public String getPlayerName(int index) {
        return players.get(index).getName();
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
