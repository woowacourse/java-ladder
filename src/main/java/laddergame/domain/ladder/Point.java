package laddergame.domain.ladder;

public enum Point {
    EMPTY, EXIST;

    public boolean isExist() {
        return this == EXIST;
    }
}
