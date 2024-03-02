package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    private static final int MIN_PLAYERS_COUNT = 2;
    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    public Players climbAllPlayers(Ladder ladder) {
        return players.stream()
                .map(player -> player.climb(ladder))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Players::new));
    }

    public int count() {
        return players.size();
    }

    public Stream<Player> stream() {
        return players.stream();
    }

    private void validate(List<Player> players) {
        validatePlayersCount(players);
        validateDuplicatedName(players);
    }

    private void validatePlayersCount(List<Player> players) {
        if (players.size() < MIN_PLAYERS_COUNT) {
            throw new IllegalArgumentException(
                    "참여자는 최소 %d명입니다.".formatted(MIN_PLAYERS_COUNT)
            );
        }
    }

    private void validateDuplicatedName(List<Player> players) {
        List<Player> distinctPlayers = new ArrayList<>();
        players.forEach(player -> {
            throwExceptionIfContains(distinctPlayers, player);
            distinctPlayers.add(player);
        });
    }

    private static void throwExceptionIfContains(List<Player> distinctPlayers, Player player) {
        if (distinctPlayers.contains(player)) {
            throw new IllegalArgumentException(
                    "중복된 이름은 입력할 수 없습니다: %s".formatted(player.name().value())
            );
        }
    }
}
