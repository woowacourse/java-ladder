package domain.ladder;

public enum Bridge {
    EMPTY(false), EXIST(true);

    private final boolean existence;

    Bridge(final boolean existence) {
        this.existence = existence;
    }

    public static Bridge getOne(boolean existence) {
        if (existence) {
            return EXIST;
        }
        return EMPTY;
    }

    public boolean isExist() {
        return this.existence;
    }
}
