package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderService {

    public static final String ALL = "all";

    private final People people;
    private final Ladder ladder;
    private final Results results;

    public LadderService(People people, Ladder ladder, Results results) {
        this.people = people;
        this.ladder = ladder;
        this.results = results;
    }

    public Results calculateAndGetResults(String input) {
        if (input.equals(ALL)) {
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
        int startColumn = people.findPersonColumn(name);
        int resultColumn = ladder.startFromColumnAndGetResultColumn(startColumn);
        return results.getResultByColumn(resultColumn);
    }

    public People getPeople() {
        return people;
    }
}
