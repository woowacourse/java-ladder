package ladder.model;


import java.util.Random;

public class Bridge {

    private static final Random RANDOM = new Random();
    private static final boolean DISCONNECTED = false;
    private static final int MOVE_LEFT = -1;
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_NONE = 0;
    private static final String EMPTY_LINE = "     ";
    private static final String FILLED_LINE = "-----";

    private final boolean left;
    private final boolean current;

    private Bridge(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public static Bridge firstBridge() {
        return new Bridge(false, RANDOM.nextBoolean());
    }

    public static Bridge nextBridge(Bridge previousBridge) {
        if (previousBridge.current == DISCONNECTED) {
            return new Bridge(previousBridge.current, RANDOM.nextBoolean());
        }
        return new Bridge(previousBridge.current, DISCONNECTED);
    }

    public static Bridge lastBridge(Bridge previousBridge) {
        return new Bridge(previousBridge.current, false);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isCurrent() {
        return current;
    }

    public int move() {
        if (this.left) {
            return MOVE_LEFT;
        }
        if (this.current) {
            return MOVE_RIGHT;
        }
        return MOVE_NONE;
    }

    public boolean isValidBridge() {
        if (this.left && this.current) {
            throw new IllegalArgumentException("이어지는 Bridge 발생");
        }
        return true;
    }

    @Override
    public String toString() {
        if (this.current) {
            return FILLED_LINE;
        }
        return EMPTY_LINE;
    }
}
