package domain;

public class Height {

    public static final int MAX_HEIGHT = 10;
    public static final int MIN_HEIGHT = 2;
    public static final String INVALID_LADDER_HEIGHT_ERROR_MESSAGE = "사다리 길이는 " + MIN_HEIGHT + "에서 " + MAX_HEIGHT + "사이여야 합니다.";

    private final int targetHeight;
    private int currentHeight = 0;

    public Height(final int height){
        validateLadderHeight(height);
        this.targetHeight = height;
    }

    private static void validateLadderHeight(final int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_ERROR_MESSAGE);
        }
    }

    public boolean isNotBottom(){
        return currentHeight++ != targetHeight;
    }
}
