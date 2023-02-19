package ladder.domain.ladder;

import ladder.domain.rule.BlockGenerator;

import java.util.List;

public class TestBlockGenerator implements BlockGenerator {

    private final List<Block> blocks;

    public TestBlockGenerator(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Block generate() {
        return blocks.remove(0);
    }
}
