package domain.ladder;

import exception.ladder.InvalidLadderHeightException;

public class LadderHeight {

    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MAX_LADDER_HEIGHT = 10;
    private final int height;

    public LadderHeight(String height) {
        validate(height);
        this.height = Integer.parseInt(height);
    }

    private void validate(String height) {
        if (isNotNum(height)) {
            throw new InvalidLadderHeightException();
        }
        if (isInvalidHeight(Integer.parseInt(height))) {
            throw new InvalidLadderHeightException();
        }
    }

    private boolean isNotNum(String height) {
        try {
            Integer.parseInt(height);
            return false;
        } catch (NumberFormatException exception) {
            return true;
        }
    }

    private boolean isInvalidHeight(int heightInput) {
        return heightInput < MIN_LADDER_HEIGHT || heightInput > MAX_LADDER_HEIGHT;
    }

    public int getHeight() {
        return height;
    }
}
