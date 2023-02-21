package domain.player;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private static final int MIN_PLAYER_SIZE = 2;
    private static final int MAX_PLAYER_SIZE = 50;

    private final List<Player> players;

    public Players(List<String> playersName) {
        validateDuplicate(playersName);
        validateSize(playersName);
        this.players = createPlayers(playersName);
    }

    private List<Player> createPlayers(List<String> playersName) {
        return playersName.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private void validateDuplicate(List<String> playersName) {
        Set<String> uniqueNames = new HashSet<>(playersName);

        if (uniqueNames.size() != playersName.size()) {
            throw new IllegalArgumentException("게임 참여자의 이름은 중복될 수 없습니다.");
        }
    }

    private void validateSize(List<String> playersName) {
        if (playersName.size() < MIN_PLAYER_SIZE || playersName.size() > MAX_PLAYER_SIZE) {
            throw new IllegalArgumentException("게임 참여자 수는 최소 2명 최대 50명까지 가능합니다.");
        }
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
