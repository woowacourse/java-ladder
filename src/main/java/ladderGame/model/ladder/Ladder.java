package ladderGame.model.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Row> rows;
    private int columnNum;
    private RandomBridgeGenerator randomBridgeGenerator;

    public Ladder(RandomBridgeGenerator randomBridgeGenerator, int rowNumber, int columnNumber) {
        rows = new ArrayList();
        for (int i = 0; i < rowNumber; i++) {
            rows.add(new Row(columnNumber));
        }
        this.columnNum = columnNumber;
        this.randomBridgeGenerator = randomBridgeGenerator;

        completeLadder();
    }

    private void completeLadder() {
        while (getTruePointNumber() < randomBridgeGenerator.generateRandomBridgeCount()) {
            Location randomLocation = randomBridgeGenerator.generateRandomBridgeLocation();
            draw(randomLocation.getRow(), randomLocation.getColumn());
        }
    }

    private void draw(int row, int column) {
        rows.get(row).draw(column);
    }

    public boolean getPoint(int row, int column) {
        return rows.get(row).getBridgePointExistence(column);
    }

    public int getArrivialIndex(int startIndex) {
        int arrivalIndex = startIndex;
        for (Row row : rows) {
            arrivalIndex = row.getArrivalIndex(arrivalIndex);
        }
        return arrivalIndex;
    }

    public int getTruePointNumber() {
        return rows.stream().mapToInt(row -> row.getTrueBridgePointNumber()).sum();
    }

    public int getRowNumber() {
        return rows.size();
    }

    public int getColumns() {
        return columnNum;
    }
}
