package domain;

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

    public void createPattern(BooleanSupplier supplier) {
        IntStream.range(0, rowPattern.size())
                .forEach(index -> {
                    boolean value = supplier.getAsBoolean();
                    rowPattern.set(index, isPlaceableWithValue(index, value));
                });
    }

    private boolean isPlaceableWithValue(int index, boolean value) {
        return value && isPreviousIndexEmpty(index);
    }

    private boolean isPreviousIndexEmpty(int index) {
        return index == 0 || !rowPattern.get(index - 1);
    }

    public HorizontalLinePattern createStatus() {
        List<Boolean> placeStatuses = List.copyOf(rowPattern);
        return new HorizontalLinePattern(placeStatuses);
    }
}
