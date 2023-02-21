package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderService {

    private final People people;
    private final Ladder ladder;
    private final Results results;

    public LadderService(People people, Ladder ladder, Results results) {
        this.people = people;
        this.ladder = ladder;
        this.results = results;
    }

    public Result getSingleResult(Person person) {
        int indexByName = people.find(person);
        Position position = ladder.startByIndex(indexByName);
        return results.getByIndex(position);
    }

    public Results getAllResults() {
        List<Result> results = new ArrayList<>();
        for (Person person : people) {
            results.add(getSingleResult(person));
        }
        return new Results(results);
    }

    public People getPeople() {
        return people;
    }
}
