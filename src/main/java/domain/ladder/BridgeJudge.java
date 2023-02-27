package domain.ladder;

import java.util.List;

public class BridgeJudge {

    public boolean canMake(List<Bridge> bridges, boolean flag, int index) {
        if (flag) {
            return isFirstLine(index) || isLeftEmpty(bridges, index);
        }
        return false;
    }


    private boolean isFirstLine(int index) {
        return index == 0;
    }

    private boolean isLeftEmpty(List<Bridge> bridges, int index) {
        if (bridges.get(index - 1) == Bridge.BLOCKED)
            return true;
        return false;
    }
}
