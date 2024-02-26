package ladder.domain;

import static ladder.domain.LadderDirection.NONE;
import static ladder.domain.LadderDirection.RIGHT;

import java.util.Random;

public class DefaultLadderDirectionSelector implements LadderDirectionSelector {

    private static final Random random = new Random();

    @Override
    public LadderDirection select() {
        if (random.nextBoolean()) {
            return RIGHT;
        }
        return NONE;
    }
}
