package ladderGameSolo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Ladder {
    private static final int STANDARD_INDEX = 0;
    private static final int NEXT_INDEX = 1;

    private final List<Line> lines;

    public Ladder(int countOfPeople, int height) {
        lines = new ArrayList<>();

        for (int i = 0; i < countOfPeople; i++) {
            lines.add(new Line(height));
        }

        int lineSize = getSettingLineSize();
        for (int i = 0; i < lineSize; i++) {
            makeBridge(height, i);
        }
    }

    public Line getLineByIndex(int index) {
        return lines.get(index);
    }

    public int getLineSize() {
        return lines.size();
    }

    public int getHeight() {
        return lines.get(STANDARD_INDEX).getSize();
    }

    public int getNextLine(int position, int lineIndex) {
        Line line = getLineByIndex(lineIndex);

        return lineIndex + line.getDirectionByIndex(position).move();
    }

    private int getSettingLineSize() {
        return lines.size() - 1;
    }

    private void makeBridge(int height, int index) {
        for (int i = 0; i < height; i++) {
            checkBridgeDirection(index, i);
        }
    }

    private void checkBridgeDirection(int lineIndex, int directionIndex) {
        if (lines.get(lineIndex).isMove(directionIndex)) {
            return;
        }

        setBridge(lineIndex, directionIndex);
    }

    private void setBridge(int index, int i) {
        Random random = new Random();
        boolean right = random.nextBoolean();

        lines.get(index).updateDirection(i, new Direction(false, right));
        lines.get(index + NEXT_INDEX).updateDirection(i, new Direction(right, false));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
