package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

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

    public List<ResultItem> getAll() {
        return matches.values().stream().toList();
    }

    public boolean hasNullValue() {
        return matches.values().stream().anyMatch(Objects::isNull);
    }

    public boolean hasNullValueForKey(Name name) {
        return matches.get(name) == null;
    }
}
