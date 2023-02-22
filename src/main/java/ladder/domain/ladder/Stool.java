package ladder.domain.ladder;

public enum Stool {

    EMPTY,
    EXIST;

    public boolean isExistBlock() {
        return this == Stool.EXIST;
    }
}
