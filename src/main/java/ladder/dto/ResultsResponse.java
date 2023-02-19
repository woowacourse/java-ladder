package ladder.dto;

import java.util.stream.Collectors;
import ladder.domain.Result;
import ladder.domain.Results;

public class ResultsResponse {
    private final String results;

    public ResultsResponse(String results) {
        this.results = results;
    }

    public static ResultsResponse ofResults(Results results) {
        String resultsString = results.getResults().stream()
                .map(Result::getResult)
                .map(result -> String.format("%-5s", result))
                .collect(Collectors.joining(" "));
        return new ResultsResponse(resultsString);
    }

    public String getResults() {
        return results;
    }
}
