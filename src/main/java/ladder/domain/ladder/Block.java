package ladder.domain.ladder;

public enum Block {

    EMPTY,
    EXIST;

    public boolean isExistBlock() {
        return this == Block.EXIST;
    }
}
