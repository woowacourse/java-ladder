package ladder.domain;

import java.util.List;

public class Line {

    private final List<Boolean> blocks;

    public Line(final List<Boolean> blocks) {
        this.blocks = List.copyOf(blocks);
    }

    public List<Boolean> getBlocks() {
        return List.copyOf(blocks);
    }
}
