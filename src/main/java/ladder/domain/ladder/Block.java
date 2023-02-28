package ladder.domain.ladder;

public enum Block {
    EMPTY(false),
    EXIST(true);

    Block(boolean isExist) {
    }

    public boolean isExistBlock() {
        return this == Block.EXIST;
    }
}
