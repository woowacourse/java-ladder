package ladder.domain;

import ladder.error.ErrorMessage;

public class Bet {
    private static final int MAX_BET_LENGTH = 5;
    private static final String COMMA = ",";

    private final String bet;

    public Bet(String bet) {
        validate(bet);
        this.bet = bet;
    }

    private void validate(String bet) {
        validateNotNull(bet);
        validateLength(bet);
        validateDoesNotContainComma(bet);
    }


    private void validateNotNull(String bet) {
        if (bet == null)
            throw new IllegalArgumentException(ErrorMessage.BET_IS_NULL.getMessage());
    }

    private void validateLength(String bet) {
        if (bet.isBlank() || bet.length() > MAX_BET_LENGTH)
            throw new IllegalArgumentException(ErrorMessage.INVALID_BET_LENGTH.getMessage());
    }

    private void validateDoesNotContainComma(String bet) {
        if (bet.contains(COMMA))
            throw new IllegalArgumentException(ErrorMessage.INVALID_BET_FORMAT.getMessage());
    }

    public String getBet() {
        return bet;
    }
}
