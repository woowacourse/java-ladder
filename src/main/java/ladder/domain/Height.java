package ladder.domain;

public class Height {
    private final int height;

    public Height(int height){
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height <= 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getHeight() {
        return height;
    }
}
