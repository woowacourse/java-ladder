package domain.ladder;

import exception.ladder.InvalidLadderResultCount;
import exception.view.EmptyInputException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderPrizes {

    private static final String DELIMITER = ",";

    private final List<LadderPrize> ladderPrizes;

    private LadderPrizes(List<LadderPrize> ladderPrizes) {
        this.ladderPrizes = ladderPrizes;
    }

    public static LadderPrizes valueOf(String results, int participantCount) {
        validate(results, participantCount);
        return new LadderPrizes(makeAllLadderResult(results));
    }

    private static void validate(String results, int participantCount) {
        if (isBlank(results)) {
            throw new EmptyInputException();
        }
        if (isInvalidResultCount(results, participantCount)) {
            throw new InvalidLadderResultCount();
        }
    }

    private static boolean isBlank(String results) {
        return results == null || results.isBlank();
    }

    private static boolean isInvalidResultCount(String results, int participantCount) {
        return makeAllLadderResult(results).size() != participantCount;
    }

    private static List<LadderPrize> makeAllLadderResult(String results) {
        return Arrays.stream(results.split(DELIMITER))
            .map(LadderPrize::new)
            .collect(Collectors.toList());
    }

    public List<String> getResultNames() {
        return ladderPrizes.stream()
            .map(LadderPrize::getName)
            .collect(Collectors.toList());
    }

    public List<LadderPrize> getPrizes() {
        return Collections.unmodifiableList(ladderPrizes);
    }
}
