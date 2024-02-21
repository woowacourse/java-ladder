package ladder.domain;

import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

public class DefaultLineGenerator implements LineGenerator {

    @Override
    public Direction generate() {
        if (pickRandomBoolean()) {
            return RIGHT;
        }
        return NONE;
    }

    private boolean pickRandomBoolean() {
        return (int) (Math.random() * 2) == 1;
    }
}
