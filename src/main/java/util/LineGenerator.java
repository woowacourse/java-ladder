package util;

import java.util.Random;

public class LineGenerator implements Generator{
    private static final int NUMBER_BOUND = 2;
    private Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(NUMBER_BOUND);
    }
}

