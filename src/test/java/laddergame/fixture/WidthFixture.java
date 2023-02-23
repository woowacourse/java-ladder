package laddergame.fixture;

import laddergame.domain.Width;

public abstract class WidthFixture {
    public static Width createWidth(final int value) {
        return new Width(value);
    }
}
