package ladder.domain.randomGenerator;

import java.util.Random;

public class RandomEnergyGenerator implements NumberGenerator {

    private static final int MIN_HEALTH_ENERGY = 0;
    private static final int MAX_HEALTH_ENERGY = 9;

    @Override
    public int getRandomNumberInRange() {
        Random random = new Random();
        return random.nextInt(MIN_HEALTH_ENERGY, MAX_HEALTH_ENERGY);
    }
}
