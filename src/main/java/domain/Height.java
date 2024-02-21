package domain;

public class Height {
    private final int height;

    public Height(int height) {
        this.height = height;
    }

    public boolean isBiggerThan(int buildHeight) {
        return height > buildHeight;
    }
}
