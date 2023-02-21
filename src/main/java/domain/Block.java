package domain;

public class Block {
    private boolean isCross;

    public Block(boolean isCross) {
        this.isCross = isCross;
    }

    public void comparePreBlock(Block preBlock) {
        if (preBlock.isCross) {
            this.isCross = false;
        }
    }

    public boolean getIsCross() {
        return isCross;
    }
}
