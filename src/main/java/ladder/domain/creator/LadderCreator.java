package ladder.domain.creator;

import ladder.domain.Ladder;

public interface LadderCreator {
    Ladder create(int width, int height);
}
