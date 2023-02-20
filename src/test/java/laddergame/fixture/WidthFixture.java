package laddergame.fixture;

import laddergame.domain.Width;

public abstract class WidthFixture {
    public static Width createWidthValue1() {
        return new Width(1);
    }

    public static Width createWidthValue2() {
        return new Width(2);
    }

    public static Width createWidthValue3() {
        return new Width(3);
    }

    public static Width createWidthValue4() {
        return new Width(4);
    }
}
