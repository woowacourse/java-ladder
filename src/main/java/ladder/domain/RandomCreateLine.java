package ladder.domain;

import java.util.Random;

public class RandomCreateLine implements LineCreate {
    @Override
    public boolean checkLine() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
