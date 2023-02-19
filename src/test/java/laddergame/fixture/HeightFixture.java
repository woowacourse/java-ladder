package laddergame.fixture;

import laddergame.domain.Height;

public abstract class HeightFixture {
    public static Height createHeightValue1() {
        return new Height(1);
    }

    public static Height createHeightValue2() {
        return new Height(2);
    }

    public static Height createHeightValue3() {
        return new Height(3);
    }

    public static Height createHeightValue4() {
        return new Height(4);
    }
}
