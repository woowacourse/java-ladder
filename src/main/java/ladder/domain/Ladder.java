package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int peopleCount;
    private final int height;
    private List<Line> lines;

    public Ladder(int peopleCount, int height) {
        validate(peopleCount);
        validate(height);
        this.peopleCount = peopleCount;
        this.height = height;
        this.lines = new ArrayList<>();
    }

    private void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
    }

    public void initialize(LineGenerator lineGenerator) {
        lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(peopleCount, lineGenerator));
        }
    }

    public Direction getDirection(int height, int index) {
        Line line = lines.get(height);
        return line.getDirectionAt(index);
    }
}
