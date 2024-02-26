package ladder.domain.ladder;

import java.util.Random;

public class RandomRungGenerator implements RungGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public Rung getRandomStatusRung() {
        if (RANDOM.nextBoolean()) {
            return Rung.EXIST;
        }
        return Rung.NOT_EXIST;
    }
}
