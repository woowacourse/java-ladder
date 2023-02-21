package domain;

import java.util.Random;

public class BooleanCreatorImplements implements BooleanCreator {

    @Override
    public boolean generate() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
