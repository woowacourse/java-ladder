package ladder.domain.ladder;

public class MoveDirection {

    public static int directMove(Bar leftBar, Bar rightBar) {
        if (leftBar == Bar.TRUE) {
            return -1;
        }
        if (rightBar == Bar.TRUE) {
            return 1;
        }
        return 0;
    }
}
