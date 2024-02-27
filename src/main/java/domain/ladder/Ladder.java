package domain.ladder;

import dto.RowPatternDto;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.BooleanSupplier;

public class Ladder {

    private final List<LadderRow> rows = new ArrayList<>();
    private final LadderIndexConverter ladderIndexConverter;

    public Ladder(int playerCount, int resultSize, LadderHeight height) {
        validateHasSameSize(playerCount, resultSize);
        createLadder(playerCount, height);
        ladderIndexConverter = new LadderIndexConverter(playerCount);
    }

    private void validateHasSameSize(int playersCount, int resultsCount) {
        if (playersCount != resultsCount) {
            throw new IllegalArgumentException("사람의 수와 결과의 개수가 일치하지 않습니다.");
        }
    }

    private void createLadder(int playerCount, LadderHeight height) {
        int createdRowCount = 0;
        while (!height.isSameHeightAs(createdRowCount)) {
            LadderRow line = new LadderRow(playerCount);
            rows.add(line);
            createdRowCount++;
        }
    }

    public void drawLines(BooleanSupplier patternCreationStrategy) {
        rows.forEach(row -> row.createPattern(patternCreationStrategy));
    }

    public List<Integer> getMappedIndices() {
        ListIterator<LadderRow> iterator = rows.listIterator(rows.size());
        while (iterator.hasPrevious()) {
            List<Boolean> rowPattern = iterator.previous().getRowPattern();
            ladderIndexConverter.swapByRowPattern(rowPattern);
        }
        return ladderIndexConverter.getResultIndex();
    }

    public List<RowPatternDto> getLadderPatterns() {
        return rows.stream()
                .map(LadderRow::getRowPattern)
                .map(RowPatternDto::new)
                .toList();
    }
}
