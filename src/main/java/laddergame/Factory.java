package laddergame;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;

public interface Factory {
    Ladder create(final LadderHeight height, final int width);
}
