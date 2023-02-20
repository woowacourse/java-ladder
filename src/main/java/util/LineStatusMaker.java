package util;

import java.util.Random;

public class LineStatusMaker implements LineGenerator {

    private static final Random random = new Random();

    @Override
    public boolean generate(boolean isLeftLineExist) {
        if (isLeftLineExist) {
            return false;
        }
        return random.nextBoolean();
    }
}
