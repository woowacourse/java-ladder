package ladder.domain.ladder;

import java.util.Arrays;

public enum Direction {
    STRAIGHT(0),
    RIGHT(1),
    LEFT(-1);

    private int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public static Direction of(int direction) {
        return Arrays.stream(values())
                .filter(d -> d.match(direction))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않은 Direction 입니다."));
    }

    public static boolean isRight(Direction prevDirection){
        return prevDirection == RIGHT;
    }

    public boolean match(int direction) {
        return this.direction == direction;
    }

    public int getDirection() {
        return direction;
    }
}
