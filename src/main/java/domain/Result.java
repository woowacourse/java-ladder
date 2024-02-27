package domain;

public class Result {

    private final String prize;

    public Result(String prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return prize;
    }
}
