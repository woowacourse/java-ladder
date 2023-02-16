package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Bridge> ladder; //enum

    public Ladder(List<Bridge> ladder) {
        for (int index = 1; index < ladder.size(); index++) { //스트림
            Bridge currentBridge = ladder.get(index);
            Bridge previousBridge = ladder.get(index - 1);
            if (currentBridge.isExist() && previousBridge.isExist()) {
                throw new IllegalArgumentException("다리는 연속으로 생성되면 안됩니다.");
            }
        }
        this.ladder = ladder;
    }

    public List<Bridge> getLadder() {
        return new ArrayList<>(ladder);
    }
}
