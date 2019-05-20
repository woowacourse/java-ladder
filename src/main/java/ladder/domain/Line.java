package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> rowLines;
    private LineCreate lineCreate;

    Line(ArrayList<Boolean> rowLines, LineCreate lineCreate) {
        this.rowLines = rowLines;
        this.lineCreate = lineCreate;
    }

    public void updateRowLines() {
        rowLines.add(isEmptyLine());
    }

    private boolean isEmptyLine() {
        if(rowLines.size() !=0 ) {
            return !rowLines.get(rowLines.size() - 1) && lineCreate.checkLine();
        }
        return lineCreate.checkLine();
    }

    public List<Boolean> getRowLines() {
        return rowLines;
    }
}