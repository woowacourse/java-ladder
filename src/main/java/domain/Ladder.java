package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public static final int MAX_HEIGHT = 10;
    public static final int MIN_HEIGHT = 2;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(){

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

    public void build(int height, int width, BooleanGenerator booleanGenerator) {
        validateLadderHeight(height);
        for (int i = 0; i < height; i++) {
            Line line = new Line(booleanGenerator);
            for (int j = 0; j < width; j++) {
                line.generateFootStep();
            }
            this.lines.add(line);
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
}
