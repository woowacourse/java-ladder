package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(final List<Player> players) {
        validate(players);
        this.players = players;
    }

    public static Players from(List<String> players) {
        return new Players(convertToPlayer(players));
    }

    private void validate(List<Player> players) {
        if (hasDuplicate(players)) {
            throw new IllegalArgumentException("중복된 참가자를 입력할 수 없습니다.");
        }
    }

    private boolean hasDuplicate(List<Player> players) {
        return Set.copyOf(players).size() != players.size();
    }

    private static List<Player> convertToPlayer(List<String> players) {
        return players.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int getCount() {
        return players.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
