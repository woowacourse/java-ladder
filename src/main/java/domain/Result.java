package domain;

import java.util.List;

public class Result {

    private final List<String> results;

    public Result(List<String> results) {
        this.results = results;
    }

    public String getResultByIndex(int index) {
        return results.get(index);
    }
}
