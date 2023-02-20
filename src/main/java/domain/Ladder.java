package domain;

import domain.generator.ConnectionGenerator;

public class Ladder {

    private final Lines lines;
    private final Height height;

    public Ladder(final int numberOfPlayer, final int height, final ConnectionGenerator connectionGenerator) {
        this.lines = new Lines(numberOfPlayer, height, connectionGenerator);
        this.height = new Height(height);
    }

    public Lines getLines() {
        return this.lines;
    }

    public Height getHeight() {
        return this.height;
    }
}
