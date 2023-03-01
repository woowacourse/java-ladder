package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Players {

    private static final int PLAYER_MIN_SIZE = 1;
    private static final int PLAYER_MAX_SIZE = 20;

    private final List<Player> players;

    public Players(final List<Player> players) {
        validate(players);
        this.players = new ArrayList<>(players);
    }

    public void validate(final List<Player> players) {
        validatePlayerSize(players);
        validateDuplication(players);
    }

    private void validatePlayerSize(final List<Player> players) {
        if (players.size() < PLAYER_MIN_SIZE || players.size() > PLAYER_MAX_SIZE) {
            throw new IllegalArgumentException("참여자 수는 1명 이상 20명 이하입니다.");
        }
    }

    private void validateDuplication(final List<Player> players) {
        List<String> playerNames = players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
        if (playerNames.size() != new HashSet<>(playerNames).size()) {
            throw new IllegalArgumentException("참여자 이름은 중복될 수 없습니다.");
        }
    }

    public Player get(final String playerName) {
        return players.stream()
                .filter(player -> player.getName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("찾는 플레이어가 없습니다."));
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
