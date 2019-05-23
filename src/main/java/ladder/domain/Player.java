package ladder.domain;

public class Player {
    private String name;
    private int position;

    public Player(final String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int playerSize, Direction direction) {
        int nextCurrent = direction.move();
        if (nextCurrent == -1 && this.position > 0) {
            this.position--;
            return;
        }
        if (nextCurrent == 1 && this.position < playerSize) {
            this.position++;
            return;
        }

    }

}