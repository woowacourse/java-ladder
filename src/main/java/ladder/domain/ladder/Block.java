package ladder.domain.ladder;

public enum Block {
    EMPTY(false),
    EXIST(true);

    private final boolean isExist;

    Block(boolean isExist) {
        this.isExist = isExist;
    }

    public boolean isExistBlock() {
        return this == Block.EXIST;
    }
}
