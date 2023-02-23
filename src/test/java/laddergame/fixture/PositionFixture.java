package laddergame.fixture;

import laddergame.domain.Position;

public abstract class PositionFixture {
    public static Position createPosition(final int value) {
        return new Position(value);
    }
}
