package laddergame.domain.result;

import laddergame.domain.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResultBuilder {
    private final static String COMMA = ",";

    public static Results buildResults(String result) {
        InputValidator.validateInput(result);

        List<Result> results =  Arrays.stream(result.split(COMMA))
                .map(Result::new)
                .collect(Collectors.toList());

        return new Results(results);
    }
}
