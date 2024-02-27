package domain.ladder;

public enum Bridge {
    EMPTY(false), EXIST(true);

    private final boolean existence;

    Bridge(final boolean existence) {
        this.existence = existence;
    }

    public boolean isExist() {
        return this.existence;
    }
}
