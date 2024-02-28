package domain.model;

public class LadderGame {
    private final Ladder ladder;
    private final People people;
    private final ResultCandidate resultCandidate;
    public LadderGame(Ladder ladder, People people,ResultCandidate resultCandidate) {
        this.ladder = ladder;
        this.people = people;
        this.resultCandidate=resultCandidate;
    }
}
