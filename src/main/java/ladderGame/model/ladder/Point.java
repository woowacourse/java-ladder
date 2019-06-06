package ladderGame.model.ladder;

public class Point {
    private boolean drawn;

    Point(boolean drawn) {
        this.drawn = drawn;
    }

    public void setTrue() {
        drawn = true;
    }

    public boolean isTrue() {
        return drawn == true;
    }
}
