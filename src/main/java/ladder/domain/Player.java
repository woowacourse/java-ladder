package ladder.domain;

public class Player {
    private String name;
    private int position;
    private Direction direction;

    public Player(final String name, int position, Direction direction) {
        this.name = name;
        this.position = position;
        this.direction = direction;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int playerSize) {
        int nextCurrent = direction.move();
        if (nextCurrent == -1 && this.position > 0) { // left
            this.position --;
        }
        else if(nextCurrent == 1 && this.position < playerSize ) { // right
            this.position ++;
        }

    }

}