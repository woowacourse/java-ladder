package domain;

import exception.EmpytInputException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    public static final String DELIMITER = ",";

    private final List<LadderResult> results;

    public LadderResults(String results) {
        validate(results);
        this.results = makeAllLadderResult(results);
    }

    private void validate(String results) {
        if (isBlank(results)) {
            throw new EmpytInputException();
        }
    }

    private boolean isBlank(String results) {
        return results == null || results.isBlank();
    }

    private List<LadderResult> makeAllLadderResult(String results) {
        return Arrays.stream(results.split(DELIMITER)).map(LadderResult::new).collect(Collectors.toList());
    }

    public List<String> getResults() {
        return results.stream().map(LadderResult::getName).collect(Collectors.toList());
    }
}
