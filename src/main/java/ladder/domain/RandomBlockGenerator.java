package ladder.domain;

import java.util.Random;

public class RandomBlockGenerator implements BlockGenerator {

    private final Random random;

    public RandomBlockGenerator() {
        this.random = new Random();
    }

    @Override
    public Block generate() {
        int blockCategoryCount = Block.values().length;
        return Block.of(random.nextInt(blockCategoryCount));
    }
}
