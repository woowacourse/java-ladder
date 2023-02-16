package utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    @Override
    public boolean isPoint() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
