package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Row {

    public Row(List<Boolean> rowInfos) {
        if (rowInfos.size() < 1 || rowInfos.size() > 9) {
            throw new RuntimeException("가로 라인 개수는 1이상 9 이하여야 합니다.");
        }
        IntStream.range(1, rowInfos.size())
                .forEach(index -> validateNearInfo(rowInfos, index));
    }

    private static void validateNearInfo(List<Boolean> rowInfos, int index) {
        if (rowInfos.get(index) && rowInfos.get(index - 1)) {
            throw new RuntimeException("연속해서 가로 라인이 등장할 수 없습니다.");
        }
    }
}
