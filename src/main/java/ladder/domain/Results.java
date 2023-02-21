package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> value;

    public Results(final List<Result> value) {
        this.value = value;
    }

    public static Results from(final List<String> names) {
        List<Result> results = generateResults(names);
        return new Results(results);
    }

    private static List<Result> generateResults(final List<String> names) {
        return names.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return value.size();
    }
}
