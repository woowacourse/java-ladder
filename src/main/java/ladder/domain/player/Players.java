package ladder.domain.player;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class Players {

    private static final int MIN_PLAYER_COUNT = 2;

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = Objects.requireNonNull(players);
        validatePlayersCount();
        validateDuplicatedName();
    }

    private void validatePlayersCount() {
        if (players.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참여자는 최소 %d명입니다.".formatted(MIN_PLAYER_COUNT));
        }
    }

    private void validateDuplicatedName() {
        Set<Player> distinctPlayers = new HashSet<>();
        players.forEach(player -> distinctPlayers.add(requireNotDuplicated(distinctPlayers, player)));
    }

    private Player requireNotDuplicated(final Set<Player> distinctPlayers, final Player player) {
        if (distinctPlayers.contains(player)) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다: %s".formatted(player));
        }
        return player;
    }

    public void forEach(final Consumer<Player> consumer) {
        players.forEach(consumer);
    }

    public int orderOf(final Player player) {
        return players.indexOf(player);
    }

    public int count() {
        return players.size();
    }
}
