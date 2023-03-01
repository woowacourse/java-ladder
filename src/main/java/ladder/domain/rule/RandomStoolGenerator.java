package ladder.domain.rule;

import ladder.domain.ladder.Stool;

import java.util.List;
import java.util.Random;

public class RandomStoolGenerator implements StoolGenerator {

    private static final List<Stool> STOOLS = List.of(Stool.values());

    private final Random random;

    public RandomStoolGenerator() {
        this.random = new Random();
    }

    @Override
    public Stool generate() {
        int randomIndex = random.nextInt(STOOLS.size());
        return STOOLS.get(randomIndex);
    }
}
