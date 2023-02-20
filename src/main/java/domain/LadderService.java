package domain;

public class LadderService {
    public static final String PRINT_FORMAT = "%s : %s\n";

    private final Ladder ladder;
    private final People people;
    private final Results results;

    public LadderService(Ladder ladder, People people, Results results) {
        this.ladder = ladder;
        this.people = people;
        this.results = results;
    }

    public Result getSingleResult(String name) {
        int indexByName = people.findByName(name);
        Position position = ladder.startByIndex(indexByName);
        return results.getByIndex(position);
    }
}
