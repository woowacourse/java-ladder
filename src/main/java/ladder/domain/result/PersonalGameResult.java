package ladder.domain.result;

import ladder.domain.participant.Participant;

public class PersonalGameResult {
    private final Participant participant;
    private final String result;

    public PersonalGameResult(final Participant participant, final String result) {
        this.participant = participant;
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
