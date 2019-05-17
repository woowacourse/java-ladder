package ladderGame.model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ladderGame.dto.*;

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

    public long countBridges() {
        return ladderRows.stream().mapToLong((ladderRow) -> ladderRow.countBridges()).sum();
    }

    public int getRows() {
        return ladderRows.size();
    }

    public int getColumns() {
        return ladderRows.get(0).getColumns();
    }
}
