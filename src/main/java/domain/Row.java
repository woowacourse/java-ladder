package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Row {
    private final List<Boolean> rowInfos;

    Row(List<Boolean> rowInfos) {
        IntStream.range(1, rowInfos.size())
                .forEach(index -> validateNearInfo(rowInfos, index));
        this.rowInfos = Collections.unmodifiableList(rowInfos);
    }

    private void validateNearInfo(List<Boolean> rowInfos, int index) {
        if (rowInfos.get(index) && rowInfos.get(index - 1)) {
            throw new LadderGameException(ExceptionType.ROW_NEAR);
        }
    }

    List<Boolean> getRowInfos() {
        return rowInfos;
    }
}
