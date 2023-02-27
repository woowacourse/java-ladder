package dto;

public class LadderParameter {

    private final int height;
    private final int width;

    public LadderParameter(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
