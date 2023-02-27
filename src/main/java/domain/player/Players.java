package domain.player;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private static final String PLAYER_DUPLICATE_ERROR_MESSAGE = "게임 참여자의 이름은 중복될 수 없습니다.";
    private static final String PLAYER_SIZE_ERROR_MESSAGE = "게임 참여자 수는 최소 2명 최대 50명까지 가능합니다.";

    private static final int MIN_PLAYER_SIZE = 2;
    private static final int MAX_PLAYER_SIZE = 50;

    private final List<Player> players;

    public Players(List<String> names) {
        this.players = names.stream()
                .map(name -> new Player(name, names.indexOf(name)))
                .collect(Collectors.toList());
        validateDuplicate(players);
        validateSize(players);
    }

    private void validateDuplicate(List<Player> players) {
        Set<Player> uniqueNamePlayers = new HashSet<>(players);

        if (uniqueNamePlayers.size() != players.size()) {
            throw new IllegalArgumentException(PLAYER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateSize(List<Player> players) {
        if (players.size() < MIN_PLAYER_SIZE || players.size() > MAX_PLAYER_SIZE) {
            throw new IllegalArgumentException(PLAYER_SIZE_ERROR_MESSAGE);
        }
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getSize() {
        return players.size();
    }
}
