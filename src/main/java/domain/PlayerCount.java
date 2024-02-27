package domain;

public class PlayerCount {
    private final int count;

    private PlayerCount(final int count) {
        this.count = count;
    }

    public static PlayerCount from(int count) {
        return new PlayerCount(count);
    }

    public boolean isSameWith(int otherCount) {
        return count == otherCount;
    }

    public int getCount() {
        return count;
    }
}
