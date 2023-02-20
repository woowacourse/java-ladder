package ladder.domain;

import ladder.domain.ladder.builder.BlockGenerator;
import ladder.domain.ladder.Block;

import java.util.List;

public class TestBlockGenerator implements BlockGenerator {

    private final List<Block> blocks;
    private int index;

    public TestBlockGenerator(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Block generate() {
        return blocks.get(index++);
    }
}
