package domain.db;

import java.util.Arrays;
import java.util.List;

public record Players(List<Player> players) {

    public Players(String[] names) {
        this(Arrays.stream(names).map(Player::new).toList());
        validateDuplicateNames();
    }

    private void validateDuplicateNames() {
        if (this.players.size() != getUniqueNameCount()) {
            throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다");
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
