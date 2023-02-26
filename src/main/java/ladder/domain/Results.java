package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(String resultValuesRaw) {
        this.results = new ArrayList<>();
        generateResultsByRaw(resultValuesRaw);

    }

    private void generateResultsByRaw(String resultValuesRaw) {
        Arrays.stream(resultValuesRaw.split(","))
                .forEach(resultValue -> this.results.add(new Result(resultValue)));
    }
}
