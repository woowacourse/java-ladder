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
            return getTotalResults();
        }
        return getSingleResult(input);
    }

    public ResultsMap getTotalResults() {
        Map<Person, Result> resultMap = new LinkedHashMap<>();
        for (Person person : people.getPeople()) {
            resultMap.put(person, calculateResult(person));
        }
        return new ResultsMap(resultMap);
    }

    public ResultsMap getSingleResult(String name) {
        Map<Person, Result> resultMap = new LinkedHashMap<>();
        Person targetPerson = new Person(name);
        resultMap.put(targetPerson, calculateResult(targetPerson));
        return new ResultsMap(resultMap);
    }

    public Result calculateResult(Person person) {
        Column startColumn = people.findColumnByPerson(person);
        Column resultColumn = ladder.startFromColumnAndGetResultColumn(startColumn);
        return results.getResultByColumn(resultColumn);
    }
}
