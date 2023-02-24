package domain.players;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int PLAYER_MIN_SIZE = 1;
    private static final int PLAYER_MAX_SIZE = 20;

    private final List<Player> players;

    private Players(final List<Player> players) {
        validate(players);
        this.players = new ArrayList<>(players);
    }

    public static Players valueOf(final List<String> playerNames) {
        List<Player> players = playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
        return new Players(players);
    }

    private void validate(final List<Player> players) {
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

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public int getPlayerSize() {
        return players.size();
    }

    public Player getPlayerAt(final int index) {
        return players.get(index);
    }

    public Player getPlayerByName(final String name) {
        return players.stream()
                .filter(player -> player.isMyName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참여자입니다."));
    }

}
