package domain;

public class Ladder {

    private final Lines lines;
    private final Height height;

    public Ladder(final int numberOfPlayer, final int height) {
        this.lines = new Lines(numberOfPlayer, height);
        this.height = new Height(height);
    }

    public int findLadderHeight() {
        return this.height.getHeight();
    }

    public Lines getLines() {
        return this.lines;
    }
}
