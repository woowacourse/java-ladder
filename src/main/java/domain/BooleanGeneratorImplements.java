package domain;

import java.util.Random;

public class BooleanGeneratorImplements implements BooleanGenerator {

    @Override
    public boolean generate() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
