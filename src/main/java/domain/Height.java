package domain;

import exception.InvalidLadderHeightException;
import util.StringUtil;

public class Height {

    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MAX_LADDER_HEIGHT = 10;

    private final int height;

    public Height(String height) {
        validate(height);
        this.height = Integer.parseInt(height);
    }

    private void validate(String height) {
        if (invalidNumber(height) || invalidHeight(height)) {
            throw new InvalidLadderHeightException();
        }
    }

    private boolean invalidNumber(String height) {
        return StringUtil.isNullOrBlank(height) || !height.matches("[0-9]+");
    }

    private boolean invalidHeight(String heightInput) {
        final int height = Integer.parseInt(heightInput);
        return MIN_LADDER_HEIGHT > height || height > MAX_LADDER_HEIGHT;
    }

    public int getHeight() {
        return height;
    }
}
