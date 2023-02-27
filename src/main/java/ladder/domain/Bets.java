package ladder.domain;

import ladder.error.ErrorMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Bets {
    private final List<Bet> bets;

    public Bets(List<String> bets, int countOfParticipants) {
        validate(bets, countOfParticipants);

        this.bets = bets.stream()
                .map(Bet::new)
                .collect(Collectors.toList());
    }

    private void validate(List<String> bets, int countOfParticipants) {
        if (bets.size() != countOfParticipants) {
            throw new IllegalArgumentException(ErrorMessage.DIFFERENT_PARTICIPANTS_AND_BETS_COUNT.getMessage());
        }
    }

    public List<Bet> getBets() {
        return Collections.unmodifiableList(bets);
    }

    public int size() {
        return bets.size();
    }
}
