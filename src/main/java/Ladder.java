public class Ladder {

    private final int height;

    public Ladder(int height) {
        validateHeightIsPositive(height);
        this.height = height;
    }

    private void validateHeightIsPositive(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("최대 사다리의 높이는 양수가 되어야 합니다");
        }
    }

    public int height() {
        return height;
    }
}
