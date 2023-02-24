package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Row {

    /**
     * 사다리의 첫 인덱스에 버퍼가 1개 들어가기 때문에 BUFFER_COUNT 값으로 1을 주었습니다.
     */
    public static final int BUFFER_COUNT = 1;
    private final List<Step> connected;

    Row(int width) {
        connected = new ArrayList<>(Collections.nCopies(width + BUFFER_COUNT, Step.BLANK));
    }

    void generateStep(StepGenerator stepGenerator) {
        for (int i = BUFFER_COUNT; i < connected.size(); i++) {
            connect(stepGenerator, i);
        }
    }

    private void connect(StepGenerator stepGenerator, int index) {
        if (shouldConnect(stepGenerator, index)) {
            connected.set(index, Step.CONNECTED);
        }
    }

    private boolean shouldConnect(StepGenerator stepGenerator, int index) {
        int adjacentIndex = index - 1;
        return (stepGenerator.generate() == Step.CONNECTED) && (connected.get(adjacentIndex)
            == Step.BLANK);
    }

    public int findAdjacentIndex(int index) {
        if (index >= connected.size()) {
            throw new IndexOutOfBoundsException();
        }
        if (isAdjacent(index)) {
            return index - 1;
        }
        if (isAdjacent(index + 1)) {
            return index + 1;
        }
        return index;

    }

    private boolean isAdjacent(int index) {
        if (index >= connected.size()) {
            return false;
        }
        return connected.get(index) == Step.CONNECTED;
    }

    List<Step> toDto() {
        return connected.subList(BUFFER_COUNT, connected.size());
    }
}
