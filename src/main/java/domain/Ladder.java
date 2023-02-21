package domain;

public class Ladder {

    private final Lines lines;
    private final Height height;

    public Ladder(Lines lines, Height height) {
        this.lines = lines;
        this.height = height;
    }

    public Lines getLines() {
        return this.lines;
    }
}
