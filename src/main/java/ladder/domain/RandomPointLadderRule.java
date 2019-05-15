package ladder.domain;

import java.util.Random;

public class RandomPointLadderRule implements LadderRule {
    public boolean isAvailablePoint(){
        Random random = new Random();
        return random.nextBoolean();
    }
}
