package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    public static final int MAX_HEIGHT = 10;
    public static final int MIN_HEIGHT = 2;
    private final List<Line> lines = new ArrayList<>();
    private final BooleanGenerator booleanGenerator;

    public Ladder(final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    private static void validateLadderHeight(final int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException("사다리 길이는 2에서 10사이여야 합니다.");
        }
    }

    public void build(final int height) {
        for (int i = 0; i < height; i++) {
            this.lines.add(new Line(() -> false));
        }
        validateLadderHeight(height);
    }

    public int getLineHeight() {
        return this.lines.size();
    }

    public void build(final int height, final int width) {
        validateLadderHeight(height);
        generateLines(height, width, booleanGenerator);
    }

    private void generateLines(final int height, final int width, BooleanGenerator booleanGenerator) {
        for (int currentHeight = 0; currentHeight < height; currentHeight++) {
            Line currentLine = new Line(booleanGenerator);
            generateFootsteps(width, currentLine);
            this.lines.add(currentLine);
        }
    }

    private static void generateFootsteps(final int width, final Line line) {
        for (int currentWidth = 0; currentWidth < width - 1; currentWidth++) {
            line.generateFootStep();
        }
    }

    public int getWidth() {
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
