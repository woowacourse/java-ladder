package laddergame.fixture;

import laddergame.domain.Ladder;

public abstract class LadderFixture {
    public static Ladder createLadder(final int width, final int height) {
        return new Ladder(LinesFixture.createLines(width, height));
    }
}
