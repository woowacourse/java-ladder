package ladder.domain;

import ladder.exception.LadderLengthException;

public class LadderMaker {

    public Ladder makeLadder(final int playerNumber, final int height) {
        validateLadderLength(playerNumber, height);
        return new Ladder(height);
    }

    private static void validateLadderLength(final int playerNumber, final int height) {
        if (height <= playerNumber - 1) {
            throw new LadderLengthException();
        }
    }
}
