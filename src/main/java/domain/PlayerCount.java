package domain;

public class PlayerCount {
    private int count;

    public PlayerCount(Players players) {
        this.count = players.getCount();
    }

    public boolean isBiggerThan(int buildCount) {
        return this.count > buildCount;
    }
}
