package ladderGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private List<LadderRow> ladderRows;

    public Ladder(List<LadderRow> ladderRows) {
        this.ladderRows = new ArrayList<>(ladderRows);
    }

    public boolean canDraw(int row, int column) {
        return ladderRows.get(row).canDraw(column);
    }

    public void draw(int row, int column) {
        ladderRows.get(row).draw(column);
    }

    public DrawnLadder drawn() {
        return new DrawnLadder(ladderRows.stream()
                .map((ladderRow) -> ladderRow.drawn())
                .collect(Collectors.toList()));
    }
}
