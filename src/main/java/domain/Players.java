package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {

    private static final int MIN_NAME_SIZE = 2;

    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = new ArrayList<>(players);
    }

    private void validate(List<Player> players) {
        if (players.size() < MIN_NAME_SIZE) {
            throw new IllegalArgumentException(String.format("이름은 최소 2개 이상이여햡니다. 입력값 : %d", players.size()));
        }

        if (hasDuplicateName(players)) {
            throw new IllegalArgumentException("이름은 중복 될 수 없습니다.");
        }
    }

    private boolean hasDuplicateName(List<Player> players) {
        return players.stream()
                .map(Player::getName)
                .distinct()
                .count() != players.size();
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
