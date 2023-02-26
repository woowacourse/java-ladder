package laddergame.model;

public class Result {
    private final Person person;
    private final Prize prize;

    public Result(Person person, Prize prize) {
        this.person = person;
        this.prize = prize;
    }

    public Person getPerson() {
        return person;
    }

    public Prize getPrize() {
        return prize;
    }
}
