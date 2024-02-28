package domain.model;

public class LadderGame {
    private final Ladder ladder;
    private final People people;
    private final Consequences consequences;
    public LadderGame(Ladder ladder, People people, Consequences consequences) {
        this.ladder = ladder;
        this.people = people;
        this.consequences = consequences;
    }
}
