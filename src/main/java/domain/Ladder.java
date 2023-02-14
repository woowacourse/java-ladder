package domain;

import exception.InvalidLadderHeightException;

public class Ladder {

    private final boolean[] status;

    public Ladder(int height) {
        final int maxHeight = 10;
        final int minHeight = 1;
        if (height < minHeight || height > maxHeight) {
            throw new InvalidLadderHeightException();
        }
        status = new boolean[maxHeight];
    }
}
