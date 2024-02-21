package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Row {
    private final List<Boolean> rowInfos;

    Row(List<Boolean> rowInfos) {
        validateRowInfosCount(rowInfos);
        IntStream.range(1, rowInfos.size())
                .forEach(index -> validateNearInfo(rowInfos, index));
        this.rowInfos = Collections.unmodifiableList(rowInfos);
    }

    private static void validateRowInfosCount(List<Boolean> rowInfos) {
        if (rowInfos.size() < 1 || rowInfos.size() > 9) {
            throw new RuntimeException("가로 라인 개수는 1이상 9 이하여야 합니다.");
        }
    }

    private static void validateNearInfo(List<Boolean> rowInfos, int index) {
        if (rowInfos.get(index) && rowInfos.get(index - 1)) {
            throw new RuntimeException("연속해서 가로 라인이 등장할 수 없습니다.");
        }
    }

    List<Boolean> getRowInfos() {
        return rowInfos;
    }
}
