package ladder.domain;

import java.util.ArrayList;

public class Line {
    private ArrayList<Boolean> rowLines;
    private LineCreate lineCreate;

    Line(ArrayList<Boolean> rowLines, LineCreate lineCreate) {
        this.rowLines = rowLines;
        this.lineCreate = lineCreate;
    }

    public void updateRowLines() {
        rowLines.add(!rowLines.get(rowLines.size() - 1) && lineCreate.checkLine());
    }

    public ArrayList<Boolean> getRowLines() {
        return rowLines;
    }
}