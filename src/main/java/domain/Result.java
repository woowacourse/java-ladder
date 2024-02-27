package domain;

import java.util.Map;

public class Result {
    private final Map<String, String> results;

    public Result(Map<String, String> results) {
        this.results = results;
    }

    public String getResultByPerson(String name) {
        return results.get(name);
    }
}
