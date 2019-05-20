package ladder.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GamePlayers {
    private static final int MIN_PLAYERS_NUMBER = 2;

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
        if (players.size() < MIN_PLAYERS_NUMBER) {
            throw new IllegalArgumentException("두 명 이상 입력 해주세요.");
        }
    }

    private void validateDuplication(List<Player> players) {
        Set<Player> set = new HashSet<>(players);
        if (set.size() != players.size()) {
            throw new IllegalArgumentException("이름 중복은 안됩니다.");
        }
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public List<Player> getAllPlayers() {
        return players;
    }

    public int size() {
        return players.size();
    }
}
