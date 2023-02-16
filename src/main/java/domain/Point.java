package domain;

public enum Point {
    PASSABLE,
    BLOCKED;

    public boolean isPassable() {
        return this.equals(PASSABLE);
    }
}
