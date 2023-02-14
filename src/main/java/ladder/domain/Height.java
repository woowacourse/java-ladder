package ladder.domain;

public class Height {

    private final int h;

    public Height(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException();
        }
        h = height;
    }

    public int getH() {
        return h;
    }

}
