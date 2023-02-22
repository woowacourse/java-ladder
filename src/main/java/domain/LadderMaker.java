package domain;

import domain.generator.BooleanGenerator;
import domain.ladder.Height;
import domain.ladder.Lines;

public class LadderMaker {

    private final Lines lines;

    private LadderMaker(Lines lines) {
        this.lines = lines;
    }

    public static LadderMaker of(int number, Height height, BooleanGenerator booleanGenerator) {
        Lines lines = new Lines(number, height.getHeight(), booleanGenerator);
        return new LadderMaker(lines);
    }

    public Lines getLines() {
        return lines;
    }
}
