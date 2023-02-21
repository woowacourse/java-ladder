package laddergame.fixture;

import laddergame.domain.Position;

public abstract class PositionFixture {
    public static Position createPositionZero() {
        return new Position(0);
    }
}
