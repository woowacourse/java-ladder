package domain;

import java.util.List;

public class Results {

    private final List<Result> results;

    private Results(List<Result> results){
        this.results = results;
    }

    public static Results of(List<Result> results){
        return new Results(results);
    }

    public Result get(int index){
        return results.get(index);
    }

    public List<Result> getResults() {
        return results;
    }
}
