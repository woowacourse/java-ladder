package domain;

import java.util.Random;

public enum Point {
    EXIST(true),
    NOT_EXIST(false);

    private final boolean isExist;

    Point(boolean isExist) {
        this.isExist = isExist;
    }

    public static Point generate(final Point previousPoint, final Random random) {
        if (previousPoint == EXIST) {
            return NOT_EXIST;
        }
        return generate(random);
    }

    public static Point generate(final Random random) {
        return of(random.nextBoolean());
    }

    private static Point of(final boolean isExist) {
        if (isExist) {
            return EXIST;
        }
        return NOT_EXIST;
    }

    public boolean isExist() {
        return this.isExist;
    }

}
