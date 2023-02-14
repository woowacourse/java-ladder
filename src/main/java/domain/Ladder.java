package domain;

import exception.InvalidLadderHeightException;

public class Ladder {

    private final boolean[] status;

    public Ladder(int height) {
        validateHeight(height);
        status = new boolean[height];
    }

    private void validateHeight(int height) {
        if (isValidHeight(height)) {
            throw new InvalidLadderHeightException();
        }
    }

    private boolean isValidHeight(int height) {
        final int maxHeight = 10;
        final int minHeight = 1;
        return height < minHeight || height > maxHeight;
    }
}
