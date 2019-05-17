package ladder.model.validator;

public class LadderValidator {
    private static final int MIN_HEIGHT = 1;

    public static void checkHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException();
        }
    }
}
