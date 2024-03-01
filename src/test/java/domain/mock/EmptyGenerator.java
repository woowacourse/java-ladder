package domain.mock;

import domain.PointState;
import domain.RandomGenerator;

public class EmptyGenerator implements RandomGenerator {
    @Override
    public PointState next() {
        return PointState.EMPTY;
    }
}
