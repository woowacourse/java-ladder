package ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class Players {

    private static final int MIN_PLAYER_COUNT = 2;

    private final List<Player> players;

    public Players(List<String> names) {
        validate(names);
        players = names.stream()
                .map(Player::new)
                .toList();
    }

    private void validate(List<String> names) {
        validatePlayersCount(names);
        validateDuplicatedName(names);
    }

    private void validatePlayersCount(List<String> names) {
        if (names.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참여자는 최소 %d명입니다.".formatted(MIN_PLAYER_COUNT));
        }
    }


    private void validateDuplicatedName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }

    public int count() {
        return players.size();
    }

    public Stream<Player> stream() {
        return players.stream();
    }
}
