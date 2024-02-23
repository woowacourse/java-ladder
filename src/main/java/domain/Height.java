package domain;

public class Height {

    private static final int MINIMUM_HEIGHT = 2;
    private static final int MAXIMUM_HEIGHT = 10;

    private int height;

    public Height(int height) {
        validateRange(height);
        this.height = height;
    }

    private void validateRange(int height) {
        if (height < MINIMUM_HEIGHT || MAXIMUM_HEIGHT < height) {
            throw new IllegalArgumentException(String.format("높이는 2 이상 10 이하만 가능합니다. 입력 값 : %d", height));
        }
    }

    public boolean isRemain() {
        return this.height != 0;
    }

    public void decrease() {
        this.height--;
    }
}
