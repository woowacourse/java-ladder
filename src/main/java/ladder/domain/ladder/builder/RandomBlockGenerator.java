package ladder.domain.ladder.builder;

import ladder.domain.ladder.Block;

import java.util.Random;

public class RandomBlockGenerator implements BlockGenerator {

    private final Random random;

    public RandomBlockGenerator() {
        this.random = new Random();
    }

    @Override
    public Block generate() {
        Block[] blocks = Block.values();
        int randomIndex = random.nextInt(blocks.length);
        return blocks[randomIndex];
    }
}
