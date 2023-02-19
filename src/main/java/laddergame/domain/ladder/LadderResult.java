package laddergame.domain.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {

    private static final String DELIMITER = ",";

    private final List<String> results;

    private LadderResult(final String results) {
        List<String> ladderResults = splitResults(results);
        this.results = trimResults(ladderResults);
    }

    public static LadderResult create(final String results) {
        return new LadderResult(results);
    }

    private List<String> splitResults(final String results) {
        return Arrays.asList(results.split(DELIMITER));
    }

    private List<String> trimResults(final List<String> results) {
        return results.stream().map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getResults() {
        return List.copyOf(results);
    }
}
