package ladder.domain.ladder;

public enum Stool {

    EMPTY,
    EXIST;

    public boolean isExistStool() {
        return this == Stool.EXIST;
    }
}
