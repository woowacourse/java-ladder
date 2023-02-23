package domain.ladder;

import exception.ladder.InvalidLadderResultCount;
import exception.view.EmptyInputException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderPrizes {

    private static final String DELIMITER = ",";

    private final List<LadderPrize> results;

    public LadderPrizes(String results, int participantCount) {
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

    static private List<LadderPrize> makeAllLadderResult(String results) {
        return Arrays.stream(results.split(DELIMITER))
            .map(LadderPrize::new)
            .collect(Collectors.toList());
    }

    public List<String> getResultNames() {
        return results.stream()
            .map(LadderPrize::getName)
            .collect(Collectors.toList());
    }

    public List<LadderPrize> getResults() {
        return Collections.unmodifiableList(results);
    }
}
