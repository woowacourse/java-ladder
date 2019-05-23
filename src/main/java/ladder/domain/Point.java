package ladder.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public enum  Point {
    TRUE(true),
    FALSE(false);

    private static final String EX_ILLEGAL_POINT = "Point에 잘못된 값이 들어왔습니다.";
    private final boolean status;

    Point(boolean status) {
        this.status = status;
    }

    public static Point valueOf(boolean status) {
        for (Point point : values()) {
            if (point.status == status) {
                return point;
            }
        }

        throw new IllegalArgumentException(EX_ILLEGAL_POINT);
    }

    public int move(int index, Point prePoint) {
        if (status) {
            return index + 1;
        }

        if (index != 0 && prePoint.status) {
            return index - 1;
        }

        return index;
    }

    public boolean status() {
        return status;
    }
}

class Test {
    public static void main(String[] args) {
        Point point = Point.FALSE;
        point.status();
        point.move(0,Point.TRUE);
    }
}
