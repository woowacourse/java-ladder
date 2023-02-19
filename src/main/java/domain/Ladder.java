package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();
    private final BooleanGenerator booleanGenerator;

    public Ladder(final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public int getLineHeight() {
        return this.lines.size();
    }

    public void build(final Height height, final int width) {
        generateLines(height, width, booleanGenerator);
    }

    private void generateLines(final Height height, final int width, BooleanGenerator booleanGenerator) {
        while(height.isNotBottom()){
            Line currentLine = new Line(booleanGenerator);
            generateFootsteps(width, currentLine);
            this.lines.add(currentLine);
        }
    }

    private void generateFootsteps(final int width, final Line line) {
        for (int currentWidth = 0; currentWidth < width - 1; currentWidth++) {
            line.generateFootStep();
        }
    }

    public int getWidth() {
        if(this.lines.isEmpty()){
            return 0;
        }

        return this.lines
                .get(0)
                .getWidth();
    }

    public List<List<Boolean>> getValue() {
        return lines.stream()
                .map(Line::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                ", booleanGenerator=" + booleanGenerator +
                '}';
    }
}
