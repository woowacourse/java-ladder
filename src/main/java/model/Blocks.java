package model;

import java.util.List;

public class Blocks {

    private final List<Path> blocks;

    public Blocks(List<Path> blocks) {
        this.blocks = blocks;
    }

    public List<Path> getBlocks() {
        return blocks;
    }
}
