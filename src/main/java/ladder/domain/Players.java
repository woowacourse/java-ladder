package ladder.domain;

import java.util.List;

public record Players(List<Player> players) {

    private static final int MIN_PLAYER_COUNT = 2;

    public Players {
        validate(players);
    }

    private void validate(List<Player> players) {
        validatePlayersCount(players);
        validateDuplicatedName(players);
    }

    private void validatePlayersCount(List<Player> names) {
        if (names.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참여자는 최소 %d명입니다.".formatted(MIN_PLAYER_COUNT));
        }
    }


    private void validateDuplicatedName(List<Player> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }

    public int count() {
        return players.size();
    }
}
