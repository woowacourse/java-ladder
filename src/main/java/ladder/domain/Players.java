package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Players {

    private static final int MIN_PLAYERS_COUNT = 2;

    private final List<Player> players;

    public Players(List<String> names) {
        validate(names);
        players = new ArrayList<>();
        IntStream.range(0, names.size())
                .forEach(index -> players.add(new Player(names.get(index), index)));
    }

    private void validate(List<String> names) {
        validatePlayersCount(names);
        validateDuplicatedName(names);
    }

    private void validatePlayersCount(List<String> names) {
        if (names.size() < MIN_PLAYERS_COUNT) {
            throw new IllegalArgumentException(
                    "참여자는 최소 %d명입니다.".formatted(MIN_PLAYERS_COUNT)
            );
        }
    }

    private void validateDuplicatedName(List<String> names) {
        List<String> distinctNames = new ArrayList<>();
        names.forEach(name -> {
            throwExceptionIfContains(distinctNames, name);
            distinctNames.add(name);
        });
    }

    private static void throwExceptionIfContains(List<String> distinctNames, String name) {
        if (distinctNames.contains(name)) {
            throw new IllegalArgumentException(
                    "중복된 이름은 입력할 수 없습니다: %s".formatted(name)
            );
        }
    }

    public int count() {
        return players.size();
    }

    public Stream<Player> stream() {
        return players.stream();
    }
}
