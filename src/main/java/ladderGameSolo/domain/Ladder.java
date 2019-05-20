package ladderGameSolo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Ladder {
    private List<Line> lines;

    public Ladder(int countOfPeople, int height) {
        lines = new ArrayList<>();

        for (int i = 0; i < countOfPeople; i++) {
            lines.add(new Line(height));
        }

        for (int i = 0; i < lines.size() - 1; i++) {
            makeBridge(height, i);
        }
    }

    public Line getLineByIndex(int index) {
        return lines.get(index);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getNextLine(int position, int lineIndex) {
        Line line = getLineByIndex(lineIndex);

        return lineIndex + line.getDirectionByIndex(position).move();
    }

    private void makeBridge(int height, int index) {
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            setBridge(index, random, i);
        }
    }

    private void setBridge(int index, Random random, int i) {
        if (lines.get(index).getDirections().get(i).move() != 0) {
            return;
        }

        boolean right = random.nextBoolean();

        lines.get(index).getDirections().set(i, new Direction(false, right));
        lines.get(index + 1).getDirections().set(i, new Direction(right, false));
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
