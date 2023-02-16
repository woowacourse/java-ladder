package domain.ladder;

import java.util.List;

public class PointJudge {

    public static boolean canMake(List<Boolean> points, boolean flag, int index) {
        if (flag == true) {
            return isFirstIndexOrLeftEmpty(points, index);
        }
        return false;
    }

    private static boolean isFirstIndexOrLeftEmpty(List<Boolean> points, int index) {
        if (index == 0 || points.get(index - 1) == false) {
            return true;
        }
        return false;
    }
}
