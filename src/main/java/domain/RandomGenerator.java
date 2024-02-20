package domain;

import java.util.Random;

public class RandomGenerator implements Generator {

    private static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        int randomNumber = RANDOM.nextInt(0, 2);

        if (randomNumber == 0) {
            return false;
        }
        return true;
    }
}
