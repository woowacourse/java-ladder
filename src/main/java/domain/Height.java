package domain;

public class Height {
    private final int height;

    public Height(final int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < 1) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isBiggerThan(int buildHeight) {
        return height > buildHeight;
    }
}
