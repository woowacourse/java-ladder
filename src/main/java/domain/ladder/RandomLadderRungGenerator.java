package domain.ladder;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLadderRungGenerator implements LadderRungGenerator {
    @Override
    public LadderRung generate() {
        boolean isConnected = ThreadLocalRandom.current().nextBoolean();
        return LadderRung.findLadderRung(isConnected);
    }
}
