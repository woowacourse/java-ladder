package laddergame.domain;

public enum Point {
    EMPTY, EXIST;

    public boolean isExist() {
        return this.equals(EXIST);
    }
}
