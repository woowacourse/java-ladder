package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<HorizontalLine> lines;

    public Ladder(List<HorizontalLine> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public boolean canDraw(Position row, Position leftColumn) {
        return lines.get(row.toInt()).canDraw(leftColumn);
    }

    public void draw(Position row, Position leftColumn) {
        lines.get(row.toInt()).draw(leftColumn);
    }

    public DrawnLadder drawn() {
        return new DrawnLadder(lines.stream().map(line -> line.drawn()).collect(Collectors.toList()));
    }

    public Position createFirstRowPosition() {
        return new Position(0, lines.size(), 0);
    }

    public Position createFirstColumnPosition() {
        return lines.get(0).createFirstColumnPosition();
    }

    public Position createFirstLeftColumnPosition() {
        return lines.get(0).createFirstLeftColumnPosition();
    }
}
