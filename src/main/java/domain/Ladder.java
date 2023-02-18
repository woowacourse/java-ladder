package domain;

import java.util.List;

public class Ladder {

    private final Lines lines;
    private final Height height;

    public Ladder(final Lines lines, final Height height) {
        this.lines = lines;
        this.height = height;
    }

    public int findLadderHeight() {
        return this.height.getHeight();
    }

    public List<Boolean> findFootholdsOfHeight(int indexOfHeight) {
        return this.lines.findFootholdsOfHeight(indexOfHeight);
    }

    public Lines getLines() {
        return lines;
    }
}
