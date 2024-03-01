package ladder.domain.creator;

import ladder.domain.ladder.Ladder;

public interface LadderCreator {
    Ladder create(int width, int height);
}
