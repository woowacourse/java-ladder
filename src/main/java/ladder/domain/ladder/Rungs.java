package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rungs {
    private final List<Rung> rungs;

    public Rungs(List<Rung> rungs) {
        this.rungs = new ArrayList<>(rungs);
    }

    public int findConnectedIndex(int index) {
        // index가 0보다 작으면 0으로, rungs.size보다 크면 rungs.size로 설정한다.
        int currentIndex = Math.max(0, Math.min(index, rungs.size()+1));

        if (canMoveLeft(currentIndex)) {
            return currentIndex - 1;
        }

        if (canMoveRight(currentIndex)) {
            return currentIndex + 1;
        }

        return currentIndex;
    }

    private boolean canMoveLeft(int index) {
        return index > 0 && rungs.get(index - 1).isExist();
    }

    private boolean canMoveRight(int index) {
        return index < rungs.size() && rungs.get(index).isExist();
    }

    public List<Rung> getRungs() {
        return Collections.unmodifiableList(rungs);
    }
}
