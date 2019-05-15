package ladder.model;

import ladder.validator.LadderHeightValidator;

public class LadderHeight {

    private final int height;

    public LadderHeight(int height) {
        this.height = LadderHeightValidator.validatedLadderHeight(height);
    }

    public int getHeight() {
        return height;
    }
}
