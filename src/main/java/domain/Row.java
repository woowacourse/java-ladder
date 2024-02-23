package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Row {
    private final List<Boolean> bridges;

    Row(List<Boolean> bridges) {
        IntStream.range(1, bridges.size())
                .forEach(index -> validateNearInfo(bridges, index));
        this.bridges = Collections.unmodifiableList(bridges);
    }

    private void validateNearInfo(List<Boolean> rowInfos, int index) {
        if (rowInfos.get(index) && rowInfos.get(index - 1)) {
            throw new LadderGameException(ExceptionType.ROW_NEAR);
        }
    }

    List<Boolean> getBridges() {
        return bridges;
    }
}
