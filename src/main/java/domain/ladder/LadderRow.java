package domain.ladder;

import dto.RowPatternDto;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.IntStream;

public class LadderRow {

    private final List<Boolean> rowPattern;

    public LadderRow(int playerCount) {
        this.rowPattern = new ArrayList<>();
        for (int i = 0; i < playerCount - 1; i++) {
            rowPattern.add(false);
        }
    }

    public void createPattern(BooleanSupplier patternGenerator) {
        IntStream.range(0, rowPattern.size())
                .forEach(index -> {
                    boolean value = patternGenerator.getAsBoolean();
                    rowPattern.set(index, isPlaceableWhenTryingToPlace(index, value));
                });
    }

    private boolean isPlaceableWhenTryingToPlace(int index, boolean isPlacing) {
        return isPlacing && isPreviousIndexEmpty(index);
    }

    private boolean isPreviousIndexEmpty(int index) {
        return index == 0 || !rowPattern.get(index - 1);
    }

    public RowPatternDto getRowPattern() {
        List<Boolean> placeStatuses = List.copyOf(rowPattern);
        return new RowPatternDto(placeStatuses);
    }
}
