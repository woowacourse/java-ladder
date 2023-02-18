package laddergame.fixture;

import laddergame.domain.Height;

public abstract class HeightFixture {
    public static Height getHeightValue1() {
        return new Height(1);
    }

    public static Height getHeightValue2() {
        return new Height(2);
    }

    public static Height getHeightValue3() {
        return new Height(3);
    }

    public static Height getHeightValue4() {
        return new Height(4);
    }
}
