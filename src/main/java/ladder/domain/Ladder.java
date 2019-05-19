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
}
