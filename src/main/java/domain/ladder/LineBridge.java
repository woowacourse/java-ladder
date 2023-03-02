package domain.ladder;

public enum LineBridge {
    PASSABLE,
    BLOCKED;

    public static LineBridge from(int number) {
        if (canGeneratePassable(number)) {
            return PASSABLE;
        }
        return BLOCKED;
    }

    private static boolean canGeneratePassable(int number) {
        return number >= 4;
    }

    public boolean isPassable() {
        return this.equals(PASSABLE);
    }
}
