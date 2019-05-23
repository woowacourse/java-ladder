package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    private LineCreate lineCreate;

    public LineGenerator(LineCreate lineCreate) {
        this.lineCreate = lineCreate;
    }

    Line drawLine(int width) {
        List<Boolean> rowLine = new ArrayList<>();
        Line line = new Line(rowLine, lineCreate);
        for (int i = 0; i < width; i++) {
            line.updateRowLines();
        }

        return line;
    }
}
