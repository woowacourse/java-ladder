package domain.vo;

import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = List.copyOf(results);
    }

    public Result get(final int index) {
        return results.get(index);
    }

    public List<String> mapToStrings() {
        return results.stream()
                .map(Result::getValue)
                .collect(Collectors.toList());
    }
}
