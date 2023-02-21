package domain;

import exception.EmpytInputException;
import java.util.List;

public class LadderResults {

    public static final String DELIMITER = ",";

    private final List<String> results;

    public LadderResults(String results) {
        validate(results);
        this.results = splitResult(results);
    }

    private void validate(String results) {
        if (isBlank(results)) {
            throw new EmpytInputException();
        }
    }

    private boolean isBlank(String results) {
        return results == null || results.isBlank();
    }

    private List<String> splitResult(String results) {
        return List.of(results.split(DELIMITER));
    }

    public List<String> getResults() {
        return List.copyOf(results);
    }
}
