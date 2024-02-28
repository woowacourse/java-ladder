package domain;

public class Height {

    public static final int MIN_OF_HEIGHT = 1;
    public static final int MAX_OF_HEIGHT = 100;
    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    public boolean isEnd(int nowFloor) {
        return this.height <= nowFloor;
    }

    private void validate(int height) {
        if (height < MIN_OF_HEIGHT || MAX_OF_HEIGHT < height) {
            throw new IllegalArgumentException("[ERROR] 높이는 " + MIN_OF_HEIGHT + "개 이상 "
                    + MAX_OF_HEIGHT + "개 이하여야 합니다.");
        }
    }
}
