package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

    public static final String ALL = "all";

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 10;

    private final People people;
    private final Lines lines;
    private final Results results;

    public Ladder(People people, Results results, List<Line> lines) {
        validateHeight(lines);
        this.people = people;
        this.lines = new Lines(lines);
        validateResultsCount(results);
        this.results = results;
    }

    private void validateHeight(List<Line> lines) {
        if (lines.size() < MIN_RANGE || lines.size() > MAX_RANGE) {
            throw new IllegalArgumentException(
                    String.format("사다리 높이는 %d 이상 %d 이하여야 합니다.", MIN_RANGE, MAX_RANGE));
        }
    }

    private void validateResultsCount(Results results) {
        if (results.getResults().size() != people.getCount()) {
            throw new IllegalArgumentException("실행 결과의 수는 사람 수와 같아야 합니다.");
        }
    }

    public Column calculateResult(Column column) {
        return lines.move(column);
    }

    public ResultsMap getResults(String input) {
        if (input.equals(ALL)) {
            return getTotalResults();
        }
        return getSingleResult(input);
    }

    public ResultsMap getTotalResults() {
        Map<Person, Result> resultMap = new LinkedHashMap<>();
        for (Person person : people.getPeople()) { // 이 부분에서 getter를 사용한 것이 아쉽다...
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
        Column resultColumn = calculateResult(startColumn);
        return results.getResultByColumn(resultColumn);
    }

    public int getHeight() {
        return lines.getHeight();
    }

    public int getWidth() {
        return lines.getWidth();
    }

    public Lines getLines() {
        return lines;
    }

    public People getPeople() {
        return people;
    }

    public Results getResults() {
        return results;
    }
}
