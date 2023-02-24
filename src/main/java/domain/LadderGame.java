package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    public static final String ALL = "all";

    private final People people;
    private final Ladder ladder;
    private final Results results;

    public LadderGame(People people, Results results, Ladder ladder) {
        this.people = people;
        this.ladder = ladder;
        this.results = results;
    }

    public ResultsMap getResults(String input) {
        if (input.equals(ALL)) {
            return calculateTotalResults();
        }
        Map<Person, Result> resultMap = new LinkedHashMap<>();
        Person targetPerson = new Person(input);
        resultMap.put(targetPerson, calculateSingleResult(targetPerson));
        return new ResultsMap(resultMap);
    }

    public ResultsMap calculateTotalResults() {
        Map<Person, Result> resultMap = new LinkedHashMap<>();
        for (Person person : people.getPeople()) {
            resultMap.put(person, calculateSingleResult(person));
        }
        return new ResultsMap(resultMap);
    }

    public Result calculateSingleResult(Person person) {
        Column startColumn = people.findColumnByPerson(person);
        Column resultColumn = ladder.startFromColumnAndGetResultColumn(startColumn);
        return results.getResultByColumn(resultColumn);
    }

    public People getPeople() {
        return people;
    }
}
