package domain;

import util.BooleanGenerator;
import util.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public static final int MAX_HEIGHT = 10;
    public static final int MIN_HEIGHT = 2;
    private final List<Line> lines = new ArrayList<>();
    private final BooleanGenerator booleanGenerator;

    public Ladder() {
        this.booleanGenerator = new RandomBooleanGenerator();
    }

    public Ladder(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    private static void validateLadderHeight(final int height) {
        if(height < MIN_HEIGHT || height > MAX_HEIGHT){
            throw new IllegalArgumentException("사다리 길이는 2에서 10사이여야 합니다.");
        }
    }

    public void build(final int height){
        for (int i = 0; i < height; i++) {
            this.lines.add(new Line(() -> false));
        }
        validateLadderHeight(height);
    }

    public int getLineHeight() {
        return this.lines.size();
    }

    public void build(int height, int width) {
        validateLadderHeight(height);
        generateLines(height, width, booleanGenerator);
    }

    private void generateLines(int height, int width, BooleanGenerator booleanGenerator) {
        for (int currentHeight = 0; currentHeight < height; currentHeight++) {
            Line currentLine = new Line(booleanGenerator);
            generateFootsteps(width, currentLine);
            this.lines.add(currentLine);
        }
    }

    private static void generateFootsteps(int width, Line line) {
        for (int currentWidth = 0; currentWidth < width; currentWidth++) {
            line.generateFootStep();
        }
    }

    public int getWidth() {
        return this.lines
                .get(0)
                .getWidth();
    }

    public int getTotalFootStepCount() {
        return getWidth() * getLineHeight();
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                ", booleanGenerator=" + booleanGenerator +
                '}';
    }
}
