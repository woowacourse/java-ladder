package domain;

public class LadderResult {
    public static final int MAX_LADDER_RESULT_LENGTH = 5;
    private static final int MIN_LADDER_RESULT_LENGTH = 1;
    private final String value;

    public LadderResult(String value) {
        validateLadderResultCharacter(value);
        validateLadderResultLength(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validateLadderResultCharacter(String value) {
        value.chars()
                .filter(ch -> ch == ' ')
                .findAny()
                .ifPresent(ch -> {
                    throw new LadderGameException(ExceptionType.INVALID_LADDER_RESULT_CHARACTER);
                });

    }

    private void validateLadderResultLength(String ladderResult) {
        if (ladderResult.length() < MIN_LADDER_RESULT_LENGTH || ladderResult.length() > MAX_LADDER_RESULT_LENGTH) {
            throw new LadderGameException(ExceptionType.INVALID_LADDER_RESULT_RANGE);
        }
    }


}
