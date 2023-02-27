package model;

public class Block {

    private final Pass pass;

    public Block(Pass pass) {
        this.pass = pass;
    }

    public static Block buildFirstBlock(boolean generatedPass) {
        if (generatedPass) {
            return new Block(Pass.RIGHT);
        }
        return new Block(Pass.NOTHING);
    }

    public static Block buildMiddleBlock(Block leftBlock, boolean generatedPass) {
        if (leftBlock.pass == Pass.RIGHT) {
            return new Block(Pass.LEFT);
        }
        if (!generatedPass) {
            return new Block(Pass.NOTHING);
        }
        return new Block(Pass.RIGHT);
    }

    public static Block buildLastBlock(Block leftBlock) {
        if (leftBlock.pass == Pass.RIGHT) {
            return new Block(Pass.LEFT);
        }
        return new Block(Pass.NOTHING);
    }

    public int nextLineIndex(int playerIndex) {
        return pass.nextindex(playerIndex);
    }

    public Pass getPass() {
        return pass;
    }
}
