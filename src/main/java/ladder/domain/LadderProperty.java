package ladder.domain;

public class LadderProperty {

    private final int width;
    private final int height;

    public LadderProperty(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public final int getWidth() {
        return width;
    }

    public final int getHeight() {
        return height;
    }
}
