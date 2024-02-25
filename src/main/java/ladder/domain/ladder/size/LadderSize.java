package ladder.domain.ladder.size;

public class LadderSize {
    private final Width width;
    private final Height height;

    public LadderSize(int width, int height) {
        this.width = new Width(width);
        this.height = new Height(height);
    }

    public int getWidth() {
        return width.value();
    }

    public int getHeight() {
        return height.value();
    }
}
