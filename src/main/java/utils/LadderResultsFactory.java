package utils;

import domain.LadderResults;
import java.util.List;

public class LadderResultsFactory {

    public static LadderResults createLadderResults(final List<String> results, final int numberOfPlayer) {
        validate(results, numberOfPlayer);
        return new LadderResults(results);
    }

    private static void validate(final List<String> results, final int numberOfPlayer) {
        if (results.size() != numberOfPlayer) {
            throw new IllegalArgumentException("플레이어의 수와 보상의 수는 같아야합니다.");
        }
    }
}
