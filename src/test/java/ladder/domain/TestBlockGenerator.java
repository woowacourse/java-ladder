package ladder.domain;

import java.util.List;

public class TestBlockGenerator implements BlockGenerator {

    private final List<Boolean> blocks;

    public TestBlockGenerator(List<Boolean> blocks) {
        this.blocks = blocks;
    }

    @Override
    public boolean generate() {
        return blocks.remove(0);
    }
}
