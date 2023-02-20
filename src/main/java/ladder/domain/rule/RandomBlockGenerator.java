package ladder.domain.rule;

import ladder.domain.ladder.Block;

import java.util.List;
import java.util.Random;

public class RandomBlockGenerator implements BlockGenerator {

    private static final List<Block> BLOCKS = List.of(Block.values());

    private final Random random;


    public RandomBlockGenerator() {
        this.random = new Random();
    }

    @Override
    public Block generate() {
        int randomIndex = random.nextInt(BLOCKS.size());
        return BLOCKS.get(randomIndex);
    }
}
