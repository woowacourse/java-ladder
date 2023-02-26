package domain;

import java.util.ArrayList;
import java.util.List;
import util.BooleanGenerator;

public class LadderGenerator {
    private final LineGenerator lineGenerator;
    private final List<Line> lines = new ArrayList<>();

    private int targetHeight;

    private int targetWidth;

    public LadderGenerator(final BooleanGenerator generator) {
        this.lineGenerator = new LineGenerator(generator);
    }

    public Ladder build(final int targetHeight, final int targetWidth) {
        this.lines.clear();
        this.targetHeight = targetHeight;
        this.targetWidth = targetWidth;
        buildLines();
        return new Ladder(new ArrayList<>(lines));
    }

    private void buildLines() {
        for(int currentHeight = 0; currentHeight < targetHeight; currentHeight++){
            lines.add(lineGenerator.build(targetWidth));
        }
    }
}
