package ladder.domain;

import java.util.List;

public class Line {

    private final List<Block> blocks;

    public Line(final List<Block> blocks) {
        this.blocks = List.copyOf(blocks);
    }

    public List<Block> getBlocks() {
        return List.copyOf(blocks);
    }
}
