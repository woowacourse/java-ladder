package domain.player;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Players(List<Player> players) {
    private static final int PLAYER_LENGTH_MIN = 2;
    private static final int PLAYER_LENGTH_MAX = 10;

    public Players(final List<Player> players) {
        this.players = players;
        validatePlayerNumber();
        validateNamesUniqueness();
    }

    public Players(final String[] names) {
        this(Arrays.stream(names).map(Player::new).toList());
    }

    private void validatePlayerNumber() {
        if (PLAYER_LENGTH_MIN > this.players.size() || this.players.size() > PLAYER_LENGTH_MAX) {
            final String errorMessage = String.format("%d명 이상 %d명 이하의 플레이어를 입력해 주세요.", PLAYER_LENGTH_MIN, PLAYER_LENGTH_MAX);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateNamesUniqueness() {
        if (this.players.size() != this.players.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다.");
        }
    }

    public int getSequence(final Player player) {
        final int sequence = this.players.indexOf(player);
        if (sequence == -1) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }
        return sequence;
    }

    public int size() {
        return this.players.size();
    }

    public Optional<Player> findByName(final String name) {
        return this.players.stream()
                .filter(player -> player.name().equals(name))
                .findFirst();
    }
}
