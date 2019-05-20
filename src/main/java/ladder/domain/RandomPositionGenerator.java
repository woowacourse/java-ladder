package ladder.domain;

import java.util.Random;

public class RandomPositionGenerator {
    private final Random random = new Random();
    private final Position first;

    private final int begin, end;

    public RandomPositionGenerator(Position first, long seed) {
        this.first = first;

        begin = this.first.toInt();
        end = this.first.last().toInt() + 1;

        random.setSeed(seed);
    }

    public Position generate() {
        return first.plus(random.nextInt(end - begin));
    }
}
