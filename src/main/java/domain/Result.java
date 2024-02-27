package domain;

public class Result {
    private final Name name;
    private final Prize prize;

    public Result(Name name, Prize prize) {
        this.name = name;
        this.prize = prize;
    }

    public Name getName() {
        return name;
    }

    public Prize getPrize() {
        return prize;
    }
}
