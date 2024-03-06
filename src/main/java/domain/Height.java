package domain;

public class Height {

    public static final int MIN_OF_HEIGHT = 1;
    public static final int MAX_OF_HEIGHT = 100;
    public static final String OUT_OF_RANGE_HEIGHT =
            "[ERROR] 높이는 " + MIN_OF_HEIGHT + "개 이상 " + MAX_OF_HEIGHT + "개 이하여야 합니다.";

    public Height(int height) {
        validate(height);
    }

    private void validate(int height) {
        if (height < MIN_OF_HEIGHT || MAX_OF_HEIGHT < height) {
            throw new IllegalArgumentException(OUT_OF_RANGE_HEIGHT);
        }
    }
}
