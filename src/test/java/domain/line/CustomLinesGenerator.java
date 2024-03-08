package domain.line;

import domain.ConnectionStatus;

import java.util.ArrayList;
import java.util.List;

public class CustomLinesGenerator implements RowLinesGenerator {

    private final List<List<ConnectionStatus>> lines;

    public CustomLinesGenerator(List<List<ConnectionStatus>> lines) {
        this.lines = lines;
    }

    @Override
    public List<RowLine> generateLines(int personCount, int height) {
        List<RowLine> rowLines = new ArrayList<>();
        for (List<ConnectionStatus> connectionStatuses : lines) {
            rowLines.add(new RowLine(connectionStatuses));
        }
        return rowLines;
    }
}
