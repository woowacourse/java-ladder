package ladder.domain.player;

import java.util.List;

public class Players {

    private static final int MIN_PLAYERS = 2;
    private final List<Player> values;

    private Players(List<Player> values) {
        this.values = values;
    }

    public static Players from(List<String> names) {
        List<Player> values = names.stream()
                .map(Player::new)
                .toList();
        return new Players(values);
    }

    private void validate(List<Player> values) {
        if (values.size() < MIN_PLAYERS) {
            throw new IllegalArgumentException("플레이어는 2명 이상 존재해야 합니다.");
        }
    }
}
