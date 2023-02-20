package domain;

public class LadderService {
    private final Ladder ladder;
    private final People people;
    private final Results results;

    public LadderService(Ladder ladder, People people, Results results) {
        this.ladder = ladder;
        this.people = people;
        this.results = results;
    }

    public String start(String name) {
        Position position = ladder.startByIndex(people.findByName(name));
        return results.getByIndex(position.getColumn());
    }
}
