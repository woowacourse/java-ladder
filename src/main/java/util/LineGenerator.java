package util;

import java.util.Random;

public class LineGenerator implements Generator {
    private Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
