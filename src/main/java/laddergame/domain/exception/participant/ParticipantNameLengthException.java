package laddergame.domain.exception.participant;

public class ParticipantNameLengthException extends IllegalArgumentException {

    private static final String PARTICIPANT_NAME_LENGTH = "[ERROR] 참가자 이름은 %d글자를 초과할 수 없습니다.";

    public ParticipantNameLengthException(final int length) {
        super(String.format(PARTICIPANT_NAME_LENGTH, length));
    }
}
