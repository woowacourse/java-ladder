package ladder.validator;

import ladder.constant.MessageConstant;

public class LadderHeightValidator {

    public static final int MIN_HEIGHT = 1;

    public static int validatedLadderHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(MessageConstant.ERROR_LOWER_MIN_HEIGHT);
        }


        return height;
    }
}
