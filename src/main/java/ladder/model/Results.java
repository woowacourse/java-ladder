package ladder.model;

import ladder.exceptionMessage.ExceptionMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<String> results;

    public Results(List<String> results, int playerCount) {
        validateResultCount(results.size(), playerCount);
        this.results = results.stream()
                .map(this::removeWhiteSpace)
                .collect(Collectors.toList());
    }

    private void validateResultCount(int resultCount, int playerCount) {
        if (resultCount != playerCount) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_INVALID_RESULT_COUNT.getMessage());
        }
    }

    private String removeWhiteSpace(String result) {
        return result.replaceAll(" ", "");
    }

    public List<String> getResults(){
        return Collections.unmodifiableList(results);
    }

}
