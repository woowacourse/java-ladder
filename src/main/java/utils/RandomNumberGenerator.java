package utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    Random random = new Random();

    @Override
    public boolean isPoint() {
        return random.nextBoolean();
    }
}
