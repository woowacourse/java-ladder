package domain.ladder;

import domain.player.Players;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Ladder {

    private final List<LadderRow> rows = new ArrayList<>();

    private Ladder(Players players, LadderHeight height) {
        createLadder(players, height);
    }

    public static Ladder of(Players players, LadderHeight height) {
        return new Ladder(players, height);
    }

    public void drawLines(BooleanSupplier patternGenerator) {
        rows.forEach(row -> row.createPattern(patternGenerator));
    }

    public List<LadderRowPattern> getLadderPatterns() {
        return rows.stream()
                .map(LadderRow::getRowPattern)
                .toList();
    }

    private void createLadder(Players players, LadderHeight height) {
        int currentFloor = 0;
        while (!height.hasLengthOf(currentFloor)) {
            LadderRow line = new LadderRow(players.size());
            rows.add(line);
            currentFloor++;
        }
    }
}
