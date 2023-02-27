package domain.vo;

import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = List.copyOf(results);
    }

    public static Results from(List<String> input) {
        return new Results(toResult(input));
    }

    public static List<Result> toResult(final List<String> input) {
        return input.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public List<String> mapToString() {
        return results.stream()
                .map(Result::getValue)
                .collect(Collectors.toList());
    }

    public Result get(final int index) {
        return results.get(index);
    }

}
