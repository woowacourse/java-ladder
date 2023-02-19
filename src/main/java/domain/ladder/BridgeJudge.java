package domain.ladder;

import java.util.List;

public class BridgeJudge {

    public static boolean canMake(List<Boolean> bridges, boolean flag, int index) {
        if (flag) {
            return isFirstLine(index) || isLeftEmpty(bridges, index);
        }
        return false;
    }


    private static boolean isFirstLine(int index) {
        return index == 0;
    }

    private static boolean isLeftEmpty(List<Boolean> bridges, int index) {
        return !bridges.get(index - 1);
    }
}
