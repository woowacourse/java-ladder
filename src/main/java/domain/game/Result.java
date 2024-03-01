package domain.game;

public class Result {

    private final String prize;

    public Result(final String prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return prize;
    }
}
