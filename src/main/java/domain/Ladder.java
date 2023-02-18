package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public static final int MAX_RANGE = 10;
    public static final int MIN_RANGE = 1;

    private final List<Line> lines;

    public Ladder(int personCount, int maxHeight, LadderGenerator generator) {
        validateHeight(maxHeight);
        this.lines = new ArrayList<>(maxHeight);
        initLines(personCount, maxHeight, generator);
    }

    private void validateHeight(int maxHeight) {
        if (maxHeight < MIN_RANGE || maxHeight > MAX_RANGE) {
            throw new IllegalArgumentException(
                    String.format("사다리 높이는 %d 이상 %d 이하여야 합니다", MIN_RANGE, MAX_RANGE));
        }
    }

    private void initLines(int personCount, int maxHeight, LadderGenerator generator) {
        for (int i = 0; i < maxHeight; i++) {
            List<Boolean> movements = generator.generate(personCount);
            lines.add(new Line(movements));
        }
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
