package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public static final int MAX_RANGE = 10;
    public static final int MIN_RANGE = 1;
    public static final String VALID_HEIGHT_FORMANT = "사다리 높이는 %d 이상 %d 이하여야 합니다";
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder make(int personCount, int maxHeight, LadderGenerator generator) {
        validateHeight(maxHeight);
        List<Line> lines = generator.generate(personCount, maxHeight);
        return new Ladder(lines);
    }

    private static void validateHeight(int maxHeight) {
        if (maxHeight < MIN_RANGE || maxHeight > MAX_RANGE) {
            throw new IllegalArgumentException(
                String.format(VALID_HEIGHT_FORMANT, MIN_RANGE, MAX_RANGE));
        }
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).size();
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    public ShiftType findShiftType(int widthIndex, int heightIndex) {
        Line currentLine = lines.get(heightIndex);

        if (currentLine.canGoRight(widthIndex)) {
            return ShiftType.RIGHT;
        }
        if (currentLine.canGoLeft(widthIndex)) {
            return ShiftType.LEFT;
        }
        return ShiftType.NO;
    }
}
