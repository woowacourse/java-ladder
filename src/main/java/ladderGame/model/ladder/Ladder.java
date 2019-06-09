package ladderGame.model.ladder;

import ladderGame.model.ladder.direction.Direction;
import ladderGame.model.ladder.direction.DirectionGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Row> rows;
    private int columnNum;


    public Ladder(DirectionGenerator directionGenerator, int rowNumber, int columnNumber) {
        rows = new ArrayList();
        for (int i = 0; i < rowNumber; i++) {
            rows.add(new Row(directionGenerator, columnNumber));
        }
        this.columnNum = columnNumber;
    }

    public Direction getDirection(int row, int column) {
        return rows.get(row).getDirection(column);
    }

    public int getArrivialIndex(int startIndex) {
        int arrivalIndex = startIndex;
        for (Row row : rows) {
            arrivalIndex = row.getArrivalIndex(arrivalIndex);
        }
        return arrivalIndex;
    }

    public int getBridgeNumber() {
        return rows.stream().mapToInt(row -> row.getBridgeNumber()).sum();
    }

    public int getRowNumber() {
        return rows.size();
    }

    public int getColumnNumber() {
        return columnNum;
    }
}
