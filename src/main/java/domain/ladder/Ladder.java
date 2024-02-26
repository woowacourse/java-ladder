package domain.ladder;

import domain.player.Players;
import domain.result.Result;
import domain.result.Results;
import dto.RowPatternDto;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Ladder {

    private final List<LadderRow> rows = new ArrayList<>();
    private final LadderIndexConverter ladderIndexConverter;

    public Ladder(Players players, Results results, LadderHeight height) {
        createLadder(players, height);
        ladderIndexConverter = new LadderIndexConverter(players.size());
    }

    public void drawLines(BooleanSupplier patternGenerator) {
        rows.forEach(row -> {
            row.createPattern(patternGenerator);
            ladderIndexConverter.swapByRowPattern(row.getRowPattern());
        });
    }

    public Result getResultByName(String string) {
        return null;
    }

    public List<RowPatternDto> getLadderPatterns() {
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
