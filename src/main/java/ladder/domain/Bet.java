package ladder.domain;

public class Bet {
    private static final int MIN_BET_LENGTH = 1;
    private static final int MAX_BET_LENGTH = 5;

    private final String bet;

    public Bet(String bet) {
        validate(bet);
        this.bet = bet;
    }

    private void validate(String bet) {
        validateNotNull(bet);
        validateLength(bet);
    }

    private void validateNotNull(String bet) {
        if (bet == null)
            throw new IllegalArgumentException();
    }

    private void validateLength(String bet) {
        if (bet.length() < MIN_BET_LENGTH || bet.length() > MAX_BET_LENGTH)
            throw new IllegalArgumentException();
    }

}
