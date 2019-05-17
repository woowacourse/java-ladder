package ladder.domain;

public class Player {
    private String name;
    private int position;
    private Direction direction;
    Player(final String name, int position, Direction direction) {
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

    public Direction getDirection(){
        return this.direction;
    }

    public void move(Line line) {
        int nextCurrent = direction.move();
        if (nextCurrent == -1) {
            if (this.position - 1 >= 0) {
                this.direction = direction.pre(line.getRowLines().get(this.position-1));
                this.position--;
            }
        }

        if (nextCurrent == 1) {
            if (line.getRowLines().size() > this.position + 1) {
                this.direction = direction.next(line.getRowLines().get(this.position+1));
                this.position++;
            }
        }
    }

    public void update(Direction direction) {
        this.direction = direction;
    }

}