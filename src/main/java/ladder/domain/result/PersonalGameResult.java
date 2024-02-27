package ladder.domain.result;

import ladder.domain.participant.Participant;

public class PersonalGameResult {
    private final Participant participant;
    private final String prize;

    public PersonalGameResult(final Participant participant, final String result) {
        this.participant = participant;
        this.prize = result;
    }

    public String getPrize() {
        return prize;
    }

    public boolean isResultOf(final String participantName) {
        final String owner = participant.getName();
        return owner.equals(participantName);
    }
}
