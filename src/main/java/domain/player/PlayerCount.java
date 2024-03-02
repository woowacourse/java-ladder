package domain.player;

public class PlayerCount {
    private final int count;

    private PlayerCount(final int count) {
        this.count = count;
    }

    public static PlayerCount fromPlayers(final Players players) {
        return new PlayerCount(players.getCount());
    }

    public boolean isBiggerOrThan(final int otherCount) {
        return this.count >= otherCount;
    }

    public boolean isSameWith(final int otherCount) {
        return count == otherCount;
    }
}
