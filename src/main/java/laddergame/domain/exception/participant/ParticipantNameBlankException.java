package laddergame.domain.exception.participant;

import laddergame.domain.exception.BlankException;

public class ParticipantNameBlankException extends BlankException {

    private static final String PARTICIPANT_NAME = "참가자 이름은";

    public ParticipantNameBlankException() {
        super(PARTICIPANT_NAME);
    }
}
