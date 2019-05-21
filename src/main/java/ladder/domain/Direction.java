package ladder.domain;


public class Direction {
    public boolean left;
    public boolean current;

    public Direction(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public int move() {
        if (this.left) {
            return -1;
        }
        if (this.current) {
            return 1;
        }
        return 0;
    }
}
