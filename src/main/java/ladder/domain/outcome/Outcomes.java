package ladder.domain.outcome;

import ladder.exception.outcome.MismatchedOutcomesCountException;

import java.util.List;

public class Outcomes {
    private final List<Outcome> outcomes;

    public Outcomes(final List<String> outcomes, final int neededOutcomesCount) {
        if (outcomes.size() != neededOutcomesCount) {
            throw new MismatchedOutcomesCountException();
        }
        this.outcomes = outcomes.stream()
                .map(Outcome::new)
                .toList();
    }

    public List<String> getValues() {
        return outcomes.stream()
                .map(Outcome::value)
                .toList();
    }
}
