package ladder.domain.result;

import ladder.domain.participant.Participant;

public class PersonalResult {
    private final Participant participant;
    private final String result;

    public PersonalResult(final Participant participant, final String result) {
        this.participant = participant;
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
