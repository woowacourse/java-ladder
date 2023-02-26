package laddergame.model.people;

public class Result {
    private final Person person;
    private final Prize prize;

    public Result(Person person, Prize prize) {
        this.person = person;
        this.prize = prize;
    }

    public String getPersonToName() {
        return person.getName();
    }

    public String getPrizeToString() {
        return prize.getPrize();
    }
}
