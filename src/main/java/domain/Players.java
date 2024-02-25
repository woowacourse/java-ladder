package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_PLAYER_COUNT = 10;

    private final List<Player> players = new ArrayList<>();

    public Players(final List<String> names) {
        validateNameCount(names.size());

        for (final String name : names) {
            players.add(new Player(name));
        }
    }

    private void validateNameCount(final int count) {
        if (count < MIN_PLAYER_COUNT || count > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("참가자 수는 %d명 이상 %d명 이하 이어야 합니다.", MIN_PLAYER_COUNT, MAX_PLAYER_COUNT));
        }
    }

    public int count() {
        return players.size();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
}
