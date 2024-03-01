package domain.mock;

import domain.PointState;
import domain.generator.RandomGenerator;

public class EmptyGenerator implements RandomGenerator {
    @Override
    public PointState next() {
        return PointState.EMPTY;
    }
}
