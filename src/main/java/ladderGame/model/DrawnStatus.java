package ladderGame.model;

public enum DrawnStatus {
    DRAWN,
    NON_DRAWN;

    public boolean checkDrawn() {
        return this.equals(DRAWN);
    }
}
