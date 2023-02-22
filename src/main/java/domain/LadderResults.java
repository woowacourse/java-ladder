package domain;

import exception.EmptyInputException;
import exception.InvalidLadderResultCount;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    private static final String DELIMITER = ",";

    private final List<LadderResult> results;

    public LadderResults(String results, int participantCount) {
        validate(results, participantCount);
        this.results = makeAllLadderResult(results);
    }

    private void validate(String results, int participantCount) {
        if (isBlank(results)) {
            throw new EmptyInputException();
        }
        if (isInvalidResultCount(results, participantCount)) {
            throw new InvalidLadderResultCount();
        }
    }

    private boolean isBlank(String results) {
        return results == null || results.isBlank();
    }

    private boolean isInvalidResultCount(String results, int participantCount) {
        return makeAllLadderResult(results).size() != participantCount;
    }

    static private List<LadderResult> makeAllLadderResult(String results) {
        return Arrays.stream(results.split(DELIMITER)).map(LadderResult::new).collect(Collectors.toList());
    }

    public List<String> getResultNames() {
        return results.stream().map(LadderResult::getName).collect(Collectors.toList());
    }
}
