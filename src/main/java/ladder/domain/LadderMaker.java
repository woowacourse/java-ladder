package ladder.domain;

import ladder.exception.LadderLengthException;

public class LadderMaker {

    public Ladder makeLadder(final int playerNumber, final int height) {
        if (height <= playerNumber - 1) {
            throw new LadderLengthException();
        }
        return new Ladder(height);
    }
}
