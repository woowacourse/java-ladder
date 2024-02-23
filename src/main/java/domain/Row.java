package domain;

import static domain.Names.MAX_NAMES_COUNT;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Row {
    static final int MIN_ROW_COUNT = 1;
    static final int MAX_ROW_COUNT = MAX_NAMES_COUNT - 1;

    private final List<Boolean> rowInfos;

    Row(List<Boolean> rowInfos) {
        validateRowInfosCount(rowInfos);
        IntStream.range(1, rowInfos.size())
                .forEach(index -> validateNearInfo(rowInfos, index));
        this.rowInfos = Collections.unmodifiableList(rowInfos);
    }

    List<Boolean> getRowInfos() {
        return rowInfos;
    }

    private void validateRowInfosCount(List<Boolean> rowInfos) {
        if (rowInfos.size() < MIN_ROW_COUNT || rowInfos.size() > MAX_ROW_COUNT) {
            throw new LadderGameException(ExceptionType.ROW_COUNT);
        }
    }

    private void validateNearInfo(List<Boolean> rowInfos, int index) {
        if (rowInfos.get(index) && rowInfos.get(index - 1)) {
            throw new LadderGameException(ExceptionType.ROW_NEAR);
        }
    }
}
