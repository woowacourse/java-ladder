package utils;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator {
    @Override
    public int generate() {
        return new Random().nextInt(10);
    }
}
