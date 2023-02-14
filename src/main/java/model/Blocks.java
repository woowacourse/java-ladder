package model;

import java.util.List;

public class Blocks {

    private final List<Block> blocks;

    public Blocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}
