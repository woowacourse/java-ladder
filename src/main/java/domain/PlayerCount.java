package domain;

public class PlayerCount {
    private final int count;

    private PlayerCount(final int count) {
        this.count = count;
    }

    public static PlayerCount from(int count) {
        return new PlayerCount(count);
    }

    public static PlayerCount fromPlayers(Players players) {
        return new PlayerCount(players.getCount());
    }

    public boolean isBiggerThan(int buildCount) {
        return this.count > buildCount;
    }

    public boolean isSameWith(int otherCount) {
        return count == otherCount;
    }
}
