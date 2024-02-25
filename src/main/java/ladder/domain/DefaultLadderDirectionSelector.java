package ladder.domain;

import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import java.util.Random;

public class DefaultLadderDirectionSelector implements LadderDirectionSelector {

    private static final Random random = new Random();

    @Override
    public Direction select() {
        if (random.nextBoolean()) {
            return RIGHT;
        }
        return NONE;
    }
}
