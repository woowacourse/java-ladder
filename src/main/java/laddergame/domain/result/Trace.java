package laddergame.domain.result;

public class Trace {
    private int position;

    public Trace(final int position) {
        this.position = position;
    }

    public Trace moveLeft() {
        this.position --;
        return this;
    }

    public Trace moveRight() {
        this.position ++;
        return this;
    }

    public boolean isNot(final int i) {
        return this.position != i;
    }

    public int getPosition() {
        return position;
    }
}
