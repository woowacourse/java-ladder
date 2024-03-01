package domain.mock;

import domain.PointState;
import domain.generator.RandomGenerator;

public class ConnectNextPointGenerator implements RandomGenerator {
    @Override
    public PointState next() {
        return PointState.CONNECT_NEXT_POINT;
    }
}
