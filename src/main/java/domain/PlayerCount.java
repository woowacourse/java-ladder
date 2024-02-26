package domain;

import java.util.List;

public class PlayerCount {
    private final int count;

    private PlayerCount(final int count) {
        this.count = count;
    }

    public static PlayerCount fromPlayers(List<String> players) {
        return new PlayerCount(players.size());
    }

    public boolean isBiggerThan(int otherCount) {
        return this.count > otherCount;
    }

    public boolean isSameWith(int otherCount) {
        return count == otherCount;
    }
}
