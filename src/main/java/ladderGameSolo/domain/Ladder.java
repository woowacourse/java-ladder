package ladderGameSolo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfPeople, int height) {
        lines = new ArrayList<>();

        for (int i = 0; i < countOfPeople; i++) {
            lines.add(new Line(height));
        }

        for (int i = 0; i < getSettingLineSize(); i++) {
            makeBridge(height, i);
        }
    }

    public Line getLineByIndex(int index) {
        return lines.get(index);
    }

    public int getLineSize() {
        return lines.size();
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

    private void checkBridgeDirection(int index, int i) {
        if (lines.get(index).getDirectionByIndex(i).move() != 0) {
            return;
        }

        setBridge(index, i);
    }

    private void setBridge(int index, int i) {
        Random random = new Random();
        boolean right = random.nextBoolean();

        lines.get(index).updateDirection(i, new Direction(false, right));
        lines.get(index + 1).updateDirection(i, new Direction(right, false));
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
