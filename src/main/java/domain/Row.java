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

    int move(int startPosition) {
        Boolean canGoRight = getCanGo(startPosition);
        Boolean canGoLeft = getCanGo(startPosition - 1);
        if (canGoRight) {
            return startPosition + 1;
        }
        if (canGoLeft) {
            return startPosition - 1;
        }
        return startPosition;
    }

    private Boolean getCanGo(int startPosition) {
        Boolean canGoRight;
        try {
            canGoRight = bridges.get(startPosition);
        }catch (IndexOutOfBoundsException e) {
            canGoRight = false;
        }
        return canGoRight;
    }
}
