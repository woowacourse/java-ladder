package domain;

import java.util.Random;

public class RandomLadderStrategy implements LadderStrategy {

    private static final Random random = new Random();

    @Override
    public boolean creatable() {
        return random.nextInt(0, 1) == 1;
    }
}
