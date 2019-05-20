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

    public void connect(LadderBuildingStrategy strategy, int lineNumber, int point) {
        lines.get(lineNumber).connect(strategy, point);
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
        if (isConnected(row, column)) {
            return column + 1;
        }

        if (isConnected(row, column - 1)) {
            return column - 1;
        }

        return column;
    }

    private boolean isConnected(int row, int column) {
        return (column >= LEFT_BOUNDARY_CHECK) && (column < getNumberOfPeople() - 1) && getLine(row).isConnected(column);
    }

    public Line getLine(int lineNumber) {
        return lines.get(lineNumber);
    }

    public int getHeight() {
        return lines.size();
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
//        return lines.get(0).getNumberOfPeople();
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
