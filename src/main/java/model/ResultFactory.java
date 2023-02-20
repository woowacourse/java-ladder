package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultFactory {
    private static final String WRONG_SIZE_RESULTS_ERROR = "[ERROR] 사다리 게임 결과 값의 개수는 전체 사람의 수와 동일해야 합니다.";
    private static final String RESULTS_DELIMITER = ",";

    public static List<Result> create(int playersSize, String inputResults) {
        List<String> results = splitInputResults(inputResults);
        validateRightResultsSize(playersSize, results);
        return results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private static void validateRightResultsSize(int playersSize, List<String> results) {
        if(results.size() != playersSize) {
            throw new IllegalArgumentException(WRONG_SIZE_RESULTS_ERROR);
        }
    }

    private static List<String> splitInputResults(String inputResults) {
        return Arrays.stream(inputResults.split(RESULTS_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
