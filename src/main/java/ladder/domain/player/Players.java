package ladder.domain.player;

import java.util.List;

public class Players {

    private static final int MIN_PLAYERS = 2;
    private final List<Player> values;

    private Players(List<Player> values) {
        validate(values);
        this.values = values;
    }

    public static Players from(List<String> names) {
        List<Player> values = names.stream()
                .map(Player::new)
                .toList();
        return new Players(values);
    }

    private void validate(List<Player> values) {
        validateSizeIsInRange(values);
        validatePlayerIsDistinct(values);
    }

    private void validateSizeIsInRange(List<Player> values) {
        if (values.size() < MIN_PLAYERS) {
            throw new IllegalArgumentException("플레이어는 2명 이상 존재해야 합니다.");
        }
    }

    private void validatePlayerIsDistinct(List<Player> values) {
        if (values.size() != values.stream().distinct().count()) {
            throw new IllegalArgumentException("플레이어가 중복 되어서는 안됩니다.");
        }
    }

    public Player get(int index) {
        if (index < 0 || index >= size()) {
            String message = "요청한 인덱스가 범위를 벗어났습니다 Index : %d, Size : %d".formatted(index, size());
            throw new IndexOutOfBoundsException(message);
        }
        return values.get(index);
    }

    public int size() {
        return values.size();
    }

    public List<String> getNames() {
        return values.stream()
                .map(Player::getName)
                .toList();
    }
}
