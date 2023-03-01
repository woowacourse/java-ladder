package domain.player;

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
            throw new IllegalArgumentException(String.format("플레이어는 최소 2명 이상이여햡니다. 입력값 : %d", players.size()));
        }

        if (hasDuplicateName(players)) {
            throw new IllegalArgumentException("플레이어의 이름은 중복 될 수 없습니다.");
        }
    }

    private boolean hasDuplicateName(List<Player> players) {
        return players.stream()
                .map(Player::getName)
                .distinct()
                .count() != players.size();
    }

    public boolean containName(String name) {
        return players.stream()
                .anyMatch(player -> player.isSameName(name));
    }

    public Player findPlayerByName(String name) {
        return players.stream()
                .filter(player -> player.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("해당하는 이름을 가진 Player는 존재하지 않습니다."));
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
