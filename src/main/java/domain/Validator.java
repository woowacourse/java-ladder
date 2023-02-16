package domain;

public class Validator {

    private static final int LADDER_MIN_HEIGHT = 1;
    private static final int LADDER_MAX_HEIGHT = 10;
    private static final String INVALID_LADDER_HEIGHT_MESSAGE = "사다리 높이는 1~10 사이 정수만 가능합니다.";
    public static void validateLadderHeight(int height) {
        if (height < LADDER_MIN_HEIGHT || height > LADDER_MAX_HEIGHT) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_MESSAGE);
        }
    }
}
