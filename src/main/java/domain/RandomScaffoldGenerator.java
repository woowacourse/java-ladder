package domain;

import java.util.Random;

public class RandomScaffoldGenerator implements ScaffoldGenerator {

    private static final Random random = new Random();

    @Override
    public Scaffold generate() {
        if (fiftyPercent()) {
            return Scaffold.EXIST;
        }
        return Scaffold.NONE;
    }

    private boolean fiftyPercent() {
        return random.nextBoolean();
    }
}
