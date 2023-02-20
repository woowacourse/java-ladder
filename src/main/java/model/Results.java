package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private static final String WRONG_SIZE_RESULTS_ERROR = "[ERROR] 사다리 게임 결과 값의 개수는 전체 사람의 수와 동일해야 합니다.";
    private static final String RESULTS_DELIMITER = ",";

    private final List<Result> results;

    public Results(int playersSize, String inputResults) {
        List<String> results = splitInputResults(inputResults);
        validateRightResultsSize(playersSize, results);
        this.results = results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public List<String> getValues() {
        return results.stream()
                .map(Result::getValue)
                .collect(Collectors.toList());
    }

    private void validateRightResultsSize(int playersSize, List<String> results) {
        if(results.size() != playersSize) {
            throw new IllegalArgumentException(WRONG_SIZE_RESULTS_ERROR);
        }
    }

    private List<String> splitInputResults(String inputResults) {
        return Arrays.stream(inputResults.split(RESULTS_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
