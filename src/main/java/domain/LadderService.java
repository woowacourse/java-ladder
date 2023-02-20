package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderService {

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

    public Results getAllResults() {
        List<Result> results = new ArrayList<>();
        for (Person person : people) {
            results.add(getSingleResult(person.getName()));
        }
        return new Results(results);
    }
}
