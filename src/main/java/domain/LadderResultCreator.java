package domain;

public class LadderResultCreator {
    private static final String SEPARATOR = ",";

    public void create(String rawLadderResults) {
        validateSeparator(rawLadderResults);
    }

    private void validateSeparator(String rawLadderResults) {
        boolean startsWith = rawLadderResults.startsWith(SEPARATOR);
        boolean endsWith = rawLadderResults.endsWith(SEPARATOR);
        if (startsWith || endsWith) {
            throw new LadderGameException(ExceptionType.INVALID_SEPARATOR_POSITION);
        }
    }
}
