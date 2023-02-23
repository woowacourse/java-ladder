package laddergame.fixture;

import laddergame.domain.Height;

public abstract class HeightFixture {
    public static Height createHeight(final int value) {
        return new Height(value);
    }
}
