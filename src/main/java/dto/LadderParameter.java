package dto;

public class LadderParameter {

    private final int height;
    private final int width;

    private LadderParameter(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public static LadderParameter of(int height, int width) {
        return new LadderParameter(height, width);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
