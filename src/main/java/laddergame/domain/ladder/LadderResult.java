package laddergame.domain.ladder;

import java.util.Arrays;
import java.util.List;

public class LadderResult {

    private static final String DELIMITER = ",";

    private final List<String> ladderResults;

    private LadderResult(final String results) {
        ladderResults = splitLadderResults(results);
    }

    public static LadderResult create(final String results) {
        return new LadderResult(results);
    }

    private List<String> splitLadderResults(final String results) {
        return Arrays.asList(results.split(DELIMITER));
    }
}
