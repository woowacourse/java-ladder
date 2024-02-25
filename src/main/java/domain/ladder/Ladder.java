package domain.ladder;

import domain.player.Players;
import dto.LadderRowDto;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Ladder {

    private final List<LadderRow> rows = new ArrayList<>();

    public Ladder(Players players, LadderHeight height) {
        createLadder(players, height);
    }

    public void drawLines(BooleanSupplier patternGenerator) {
        rows.forEach(row -> row.createPattern(patternGenerator));
    }

    public List<LadderRowDto> getLadderPatterns() {
        return rows.stream()
                .map(LadderRow::getRowPattern)
                .toList();
    }

    private void createLadder(Players players, LadderHeight height) {
        int createdRowCount = 0;
        while (!height.isSameHeightAs(createdRowCount)) {
            LadderRow line = new LadderRow(players.size());
            rows.add(line);
            createdRowCount++;
        }
    }
}
