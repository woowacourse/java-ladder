package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final String INVALID_BRIDGE_MESSAGE = "다리는 연속으로 생성되면 안됩니다.";
    private final List<Bridge> ladder;

    public Ladder(List<Bridge> ladder) {
        for (int index = 1; index < ladder.size(); index++) {
            validateLadder(ladder, index);
        }
        this.ladder = ladder;
    }

    private void validateLadder(List<Bridge> ladder, int index) {
        Bridge currentBridge = ladder.get(index);
        Bridge previousBridge = ladder.get(index - 1);
        if (currentBridge.isExist() && previousBridge.isExist()) {
            throw new IllegalArgumentException(INVALID_BRIDGE_MESSAGE);
        }
    }

    public List<Bridge> getLadder() {
        return new ArrayList<>(ladder);
    }
}
