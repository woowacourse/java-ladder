package laddergame.fixture;

import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Lines;

import java.util.List;

public abstract class LadderFixture {
    public static Ladder createLadderWidth3Height3() {
        final Line line1 = new Line(List.of(true, false, true));
        final Line line2 = new Line(List.of(true, false, true));
        final Line line3 = new Line(List.of(true, false, true));
        final Lines lines = new Lines(List.of(line1, line2, line3));
        return new Ladder(lines);
    }
}
