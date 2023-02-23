package ladder.domain.people;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void movePosition(int direct) {
        this.position += direct;
    }

    public int getPosition() {
        return this.position;
    }
}
