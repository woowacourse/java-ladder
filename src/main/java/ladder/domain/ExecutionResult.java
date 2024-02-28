package ladder.domain;

import java.util.LinkedHashMap;

public class ExecutionResult {

    private final LinkedHashMap<Name, ResultItem> matches;

    public ExecutionResult(People people) {
        this.matches = new LinkedHashMap<>();
        people.getNames().forEach(name -> matches.put(name, null));
    }

    public void put(Name name, ResultItem resultItem) {
        matches.put(name, resultItem);
    }

    public ResultItem get(Name name) {
        return matches.get(name);
    }
}
