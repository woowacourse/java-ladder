package domain.db;

import java.util.Arrays;
import java.util.List;

public record Players(List<Player> players) {
    private static final int PLAYER_LENGTH_MIN = 2;
    private static final int PLAYER_LENGTH_MAX = 10;

    public Players(String[] names) {
        this(Arrays.stream(names).map(Player::new).toList());
        validatePlayerLength();
        validateDuplicateNames();
    }

    private void validatePlayerLength() {
        if (PLAYER_LENGTH_MIN > this.players.size() || this.players.size() > PLAYER_LENGTH_MAX) {
            String errorMessage = String.format("%d명 이상 %d명 이하의 플레이어를 입력해 주세요.", PLAYER_LENGTH_MIN, PLAYER_LENGTH_MAX);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateDuplicateNames() {
        if (this.players.size() != getUniqueNameCount()) {
            throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다.");
        }
    }

    private long getUniqueNameCount() {
        return this.players.stream().distinct().count();
    }

    public int getSequence(final String name) {
        final int sequence = this.players.indexOf(new Player(name));
        if (sequence == -1) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다.");
        }
        return sequence;
    }

    public int size() {
        return this.players.size();
    }
}
