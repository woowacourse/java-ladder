package domain;

public class Ladder {

    private final Lines lines;
    private final Height height;

    public Ladder(final int numberOfPlayer, final int height) {
        this.lines = new Lines(numberOfPlayer, height);
        this.height = new Height(height);
    }

    public Lines getLines() {
        return lines;
    }

    public Height getHeight() {
        return height;
    }
}
