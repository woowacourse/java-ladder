package domain;

public enum LinePoint {

    PASSABLE,
    BLOCKED;

    public static LinePoint from(int number) {
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
