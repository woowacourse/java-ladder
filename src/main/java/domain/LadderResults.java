package domain;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class LadderResults {

    private static final Pattern NATURAL_NUMBER_FORMAT_REGEX = Pattern.compile("^[1-9][0-9]*$");
    private static final String LOSE = "꽝";

    private final List<String> ladderResults;

    public LadderResults(List<String> ladderResults, int columnLength) {
        validateIsNotLoseOrNaturalNumber(ladderResults);
        validateLadderResultsLength(ladderResults, columnLength);
        this.ladderResults = ladderResults;
    }

    private void validateIsNotLoseOrNaturalNumber(List<String> ladderResults) {
        for (String ladderResult : ladderResults) {
            if (!ladderResult.equals(LOSE) && !NATURAL_NUMBER_FORMAT_REGEX.matcher(ladderResult).matches()) {
                throw new IllegalArgumentException("실행 결과는 꽝 또는 자연수만 입력 가능합니다.");
            }
        }
    }

    private void validateLadderResultsLength(List<String> ladderResults, int columnLength) {
        if (ladderResults.size() != columnLength) {
            throw new IllegalArgumentException("실행 결과 개수는 참여자 수와 일치해야 합니다.");
        }
    }

    public List<String> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }
}
