package domain;

public class Result {
    private final Name name;
    private final String prize;

    public Result(Name name, String prize) {
        this.name = name;
        this.prize = prize;
    }

    public Name getName() {
        return name;
    }

    public String getPrize() {
        return prize;
    }
}
