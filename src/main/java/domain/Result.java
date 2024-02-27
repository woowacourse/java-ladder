package domain;

import java.util.Map;

public class Result {
    private final Map<String, String> results;

    public Result(Map<String, String> results) {
        this.results = results;
    }

    public String getResultByPerson(ResultName name) {
        return results.get(name.getName());
    }

    public Map<String, String> getResultByAll() {
        return results;
    }
}
