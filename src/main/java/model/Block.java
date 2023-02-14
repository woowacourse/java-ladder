package model;

public class Block {

    private final boolean pass;

    public Block(boolean pass) {
        this.pass = pass;
    }

    public boolean isLeftBlockHavePass(Block leftBlock) {
        return leftBlock.pass && this.pass;
    }

    public boolean isPass() {
        return pass;
    }
}
