package util;

import java.util.Random;

public class RandomLineGenerator implements LineGenerator {

    private final Random random = new Random();
    @Override
    public boolean generate(boolean isLeftLineExist) {
        if (isLeftLineExist) {
            return false;
        }
        return random.nextBoolean();
    }
}
