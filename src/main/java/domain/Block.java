package domain;

public class Block {
    private final boolean isCross;

    public Block(boolean isCross) {
        this.isCross = isCross;
    }

    public static Block createNextBlock(Block preBlock, BooleanGenerator booleanGenerator) {
        if (preBlock.isCross) {
            return new Block(false);
        }
        return new Block(booleanGenerator.generate());
    }

    public boolean getIsCross() {
        return isCross;
    }
}
