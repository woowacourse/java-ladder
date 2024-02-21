package domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<String> players) {
        validate(players);
        this.players = convertToPlayer(players);
    }

    private void validate(List<String> players) {
        if (hasDuplicate(players)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicate(List<String> players) {
        return Set.copyOf(players).size() != players.size();
    }

    private List<Player> convertToPlayer(List<String> players) { // todo: DTOd에서?
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
        return players;
    }
}
