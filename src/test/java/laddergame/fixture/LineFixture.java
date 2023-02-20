package laddergame.fixture;

import laddergame.domain.Line;

import java.util.List;

public abstract class LineFixture {
    public static Line createLineSize2() {
        return new Line(List.of(true, false));
    }

    public static Line createLineSize3() {
        return new Line(List.of(true, false, true));
    }
}
