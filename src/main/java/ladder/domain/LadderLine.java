package ladder.domain;

public class LadderLine {
    private final Direction direction;

    public LadderLine(Direction direction) {
        this.direction = direction;
    }

    public Direction direction() {
        return direction;
    }

    public int position() {
        return direction.number();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        LadderLine another = (LadderLine) obj;
        return this.direction.equals(another.direction);
    }
}
