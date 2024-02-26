package domain.player;

public record Position(int value) {

    public Position() {
        this(0);
    }

    public Position increase() {
        return new Position(value + 1);
    }

    public Position decrease() {
        return new Position(value - 1);
    }
}
