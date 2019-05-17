package ladderGame.model.ladder;

import ladderGame.dto.DrawnLadderRow;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {
    private final List<Boolean> bridges;

    public LadderRow(List<Boolean> bridges) {
        this.bridges = new ArrayList(bridges);
    }

    public boolean canDraw(int column) {
        return bridges.get(column) == false && hasBridgesAside(column) == false;
    }

    private boolean hasBridgesAside(int column) {
        if (0 <= column - 1 && bridges.get(column - 1)) {
            return true;
        }
        if (column + 1 < bridges.size() && bridges.get(column + 1)) {
            return true;
        }
        return false;
    }

    public void draw(int column) {
        bridges.set(column, true);
    }

    public DrawnLadderRow drawn() {
        return new DrawnLadderRow(new ArrayList<>(bridges));
    }


    public long countBridges() {
        return bridges.stream().filter((isDrawn) -> isDrawn).count();
    }

    public int getColumns() {
        return bridges.size();
    }
}
