package ladder.domain;

import java.util.ArrayList;

class LineGenerator {
    private ArrayList<Boolean> rowLines;
    private LineCreate lineCreate;

    LineGenerator(LineCreate lineCreate) {
        this.lineCreate = lineCreate;
        rowLines = new ArrayList<>();

    }

    Line drawLine(int width) {
        Line line = new Line(rowLines, lineCreate);
        for (int i = 0; i < width; i++) {
            line.updateRowLines();
        }

        return line;
    }
}
