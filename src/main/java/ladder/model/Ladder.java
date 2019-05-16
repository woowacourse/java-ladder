package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private List<LadderWidth> lines = new ArrayList<>();

    // test 코드
    public Ladder(List<LadderWidth> lines) {
        this.lines = lines;
    }

    public Ladder(LadderGamePlayers players, int height, int maxLenOfGoalNames) {
        for (int i = 0; i < height; i++) {
            lines.add(new LadderWidth(players.size() - 1, maxLenOfGoalNames));
        }
    }

    public boolean hasCrossbar(int column, int row) {
        return lines.get(row).hasCrossbar(column);
    }

    public int size() {
        return lines.size();
    }

    @Override
    public String toString() {
        return lines.stream().map(LadderWidth::toString).collect(Collectors.joining("\n"));
    }
}
