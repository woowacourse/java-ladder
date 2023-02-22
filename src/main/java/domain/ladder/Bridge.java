package domain.ladder;

public enum Bridge {

    PASSABLE,
    BLOCKED;

    public boolean isPassable() {
        return this.equals(PASSABLE);
    }
}
