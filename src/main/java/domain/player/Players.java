package domain.player;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Players {
    private final List<Player> players;

    private Players(final List<Player> players) {
        validate(players);
        this.players = players;
    }

    public static Players from(final List<String> players) {
        return new Players(convertToPlayer(players));
    }

    private void validate(final List<Player> players) {
        if (hasDuplicate(players)) {
            throw new IllegalArgumentException("중복된 참가자를 입력할 수 없습니다.");
        }
    }

    private boolean hasDuplicate(final List<Player> players) {
        return Set.copyOf(players).size() != players.size();
    }

    private static List<Player> convertToPlayer(final List<String> players) {
        return players.stream()
                .map(Player::new)
                .toList();
    }

    public Player findByIndex(final int index) {
        return players.get(index);
    }

    public boolean isCountMoreThan(final int input) {
        return players.size() > input;
    }

    public int getCount() {
        return players.size();
    }

    public void validateExistPlayer(final String inputName) {
        if (!isExistPlayer(inputName)) {
            throw new IllegalArgumentException("존재하는 참가자 중에 입력해야합니다.");
        }
    }

    private boolean isExistPlayer(final String inputName) {
        return players.stream()
                .anyMatch(player -> player.isSameName(inputName));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
