package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> rowLines;
    private LineCreate lineCreate;

    Line(List<Boolean> rowLines, LineCreate lineCreate) {
        this.rowLines = rowLines;
        this.lineCreate = lineCreate;
    }

    public void updateRowLines() {
        rowLines.add(isEmptyLine());
    }

    private boolean isEmptyLine() {
        if (rowLines.size() != 0) {
            return !rowLines.get(rowLines.size() - 1) && lineCreate.checkLine();
        }
        return lineCreate.checkLine();
    }

    public List<Boolean> getRowLines() {
        return rowLines;
    }

    public boolean getLinePosition(int position) {
        return rowLines.get(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(rowLines, line.rowLines) &&
                Objects.equals(lineCreate, line.lineCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowLines, lineCreate);
    }

}