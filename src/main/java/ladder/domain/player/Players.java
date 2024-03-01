package ladder.domain.player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public record Players(List<Player> players) {

    private static final int MIN_PLAYER_COUNT = 2;

    public Players {
        validatePlayersCount(players);
        validateDuplicatedName(players);
    }

    private void validatePlayersCount(final List<Player> names) {
        if (names.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참여자는 최소 %d명입니다.".formatted(MIN_PLAYER_COUNT));
        }
    }

    private void validateDuplicatedName(final List<Player> names) {
        Set<Player> distinctNames = new HashSet<>();
        names.forEach(name -> {
            if (distinctNames.contains(name)) {
                throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다: %s".formatted(name));
            }
            distinctNames.add(name);
        });
    }

    public void forEach(Consumer<Player> consumer) {
        players.forEach(consumer);
    }

    public int orderOf(final Player player) {
        return players.indexOf(player);
    }

    public int count() {
        return players.size();
    }
}
