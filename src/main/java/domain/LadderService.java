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

    public Results calculateAndGetResults(String input) {
        if (input.equals("all")) {
            return getTotalResults();
        }
        Result singleResult = getSingleResult(new Person(input));
        return new Results(singleResult);
    }

    public Results getTotalResults() {
        List<Result> results = new ArrayList<>();
        for (Person person : people) {
            results.add(getSingleResult(person));
        }
        return new Results(results);
    }

    public Result getSingleResult(Person name) {
        int column = people.findPersonColumn(name);
        Position position = ladder.startByColumn(column);
        return results.getResultByColumn(position);
    }

    public People getPeople() {
        return people;
    }
}
