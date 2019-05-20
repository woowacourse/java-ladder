package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final int LEFT_BOUNDARY_CHECK = 1;

    private List<Line> lines;
    private int numberOfPeople;

    public Ladder(List<Line> lines, int numberOfPeople) {
        this.lines = lines;
        this.numberOfPeople = numberOfPeople;
    }

    public LadderResult play() {
        List<Integer> result = new ArrayList<>();
        int numberOfPeople = getNumberOfPeople();

        for (int i = 0; i < numberOfPeople; i++) {
            result.add(decidePosition(i));
        }

        return new LadderResult(result);
    }

    private int decidePosition(int column) {
        int row = 0;

        while (row != getHeight()) {
            column = moveColumn(row, column);
            row++;
        }

        return column;
    }

    private int moveColumn(int row, int column) {
        if (isConnectedRight(row, column)) {
            return column + 1;
        }

        if (isConnectedLeft(row, column)) {
            return column - 1;
        }

        return column;
    }

    private boolean isConnectedRight(int row, int column) {
        return (column < getNumberOfPeople() - 1) && getLine(row).isConnected(column);
    }

    private boolean isConnectedLeft(int row, int column) {
        return (column >= LEFT_BOUNDARY_CHECK) && getLine(row).isConnected(column - 1);
    }

    public Line getLine(int lineNumber) {
        return lines.get(lineNumber);
    }

    public int getHeight() {
        return lines.size();
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return numberOfPeople == ladder.numberOfPeople &&
                Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines, numberOfPeople);
    }
}
