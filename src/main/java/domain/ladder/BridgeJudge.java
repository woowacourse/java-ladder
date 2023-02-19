package domain.ladder;

import java.util.List;

public class BridgeJudge {

    public static boolean canMake(List<Boolean> bridges, boolean flag, int index) {
        if (flag == true) {
            return isFirstIndexOrLeftEmpty(bridges, index);
        }
        return false;
    }

    private static boolean isFirstIndexOrLeftEmpty(List<Boolean> bridges, int index) {
        if (index == 0 || bridges.get(index - 1) == false) {
            return true;
        }
        return false;
    }
}
