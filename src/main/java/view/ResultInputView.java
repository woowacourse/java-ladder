package view;

import domain.ExceptionType;
import domain.LadderGameException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ResultInputView {
    static final int MAX_RESULTS_COUNT = 10;
    static final int MAX_RESULT_LENGTH = 5;
    private static final String SEPARATOR = ",";

    public static List<String> getResults(Supplier<String> supplier, int resultCount) {
        String results = supplier.get();
        validateSeparator(results);
        List<String> splitResults = splitResult(results);
        splitResults.forEach(ResultInputView::validateResultLength);
        validateResultsCount(splitResults, resultCount);
        return splitResults;
    }

    private static List<String> splitResult(String results) {
        return Arrays.stream(results.split(SEPARATOR)).toList();
    }


    private static void validateSeparator(String results) {
        boolean startsWith = results.startsWith(SEPARATOR);
        boolean endsWith = results.endsWith(SEPARATOR);
        if (startsWith || endsWith) {
            throw new LadderGameException(ExceptionType.RESULTS_SEPARATOR);
        }
    }

    private static void validateResultsCount(List<String> splitNames, int expectedResultCount) {
        if (splitNames.size() > MAX_RESULTS_COUNT) {
            throw new LadderGameException(ExceptionType.RESULTS_COUNT_RANGE);
        }
        if (splitNames.size() != expectedResultCount) {
            throw new LadderGameException(ExceptionType.RESULT_COUNT);
        }
    }

    private static void validateResultLength(String name) {
        if (name.isEmpty() || name.length() > MAX_RESULT_LENGTH) {
            throw new LadderGameException(ExceptionType.RESULT_LENGTH);
        }

    }
}
