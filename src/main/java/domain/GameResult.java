package domain;

import exception.NotFindPersonException;

import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private final Map<Person, Result> ladderResult;

    public GameResult(Map<Person, Result> ladderResult) {
        this.ladderResult = new HashMap<>(ladderResult);
    }

    public Map<Person, Result> getAllResult() {
        return ladderResult;
    }

    public Result getResultByName(String name) {
        Person findPerson = new Person(name);
        return ladderResult.entrySet()
                           .stream()
                           .filter(resultEntry -> resultEntry.getKey()
                                                             .equals(findPerson))
                           .findFirst()
                           .orElseThrow(NotFindPersonException::new)
                           .getValue();
    }
}
