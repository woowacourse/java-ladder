package ladderGame.model.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {
    private List<Row> rows;
    private int columnNum;

    public Ladder(int rowNumber, int columnNumber) {
        rows= new ArrayList();
        for (int i = 0; i < rowNumber; i++) {
            rows.add(new Row(columnNumber));
        }
        this.columnNum = columnNumber;
    }

    public void draw(int row, int column) {
        rows.get(row).draw(column);
    }

    public boolean getPoint(int row, int column) {
        return rows.get(row).getPoint(column);
    }

    public int getArrivialIndex(int startIndex) {
        int arrivalIndex = startIndex;
        for (Row row : rows) {
            arrivalIndex = row.getArrivalIndex(arrivalIndex);
        }
        return arrivalIndex;
    }

    public int getTruePointNumber() {
        return rows.stream().mapToInt(row -> row.getTruePointNumber()).sum();
    }

    public int getRowNumber() {
        return rows.size();
    }

    public int getColumns() {
        return columnNum;
    }
}
