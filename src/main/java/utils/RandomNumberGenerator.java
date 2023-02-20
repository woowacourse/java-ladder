package utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    @Override
    public boolean isMovable() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
