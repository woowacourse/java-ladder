package ladder.model.generator;

import ladder.model.Result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultsGenerator {
    public static List<Result> generateResults(String[] resultItems) {
        return Arrays.stream(resultItems)
                .map(Result::new)
                .collect(Collectors.toList());
    }
}
