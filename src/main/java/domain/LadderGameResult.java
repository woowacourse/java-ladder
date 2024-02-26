package domain;

public class LadderGameResult {
    public LadderGameResult(Names names, LadderResults ladderResults) {
        validateNamesLadderResultLength(names, ladderResults);

    }

    private void validateNamesLadderResultLength(Names names, LadderResults ladderResults) {
        if (names.getNameCount() != ladderResults.getLadderResults().size()) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH);
        }
    }
}
