package domain.vo;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private final List<Result> results = new ArrayList<>();

    public void add(Result result) {
        results.add(result);
    }

    public void addAll(List<Result> results) {
        this.results.addAll(results);
    }

    public String get(int order) {
        return results.get(order).getValue();
    }
}
