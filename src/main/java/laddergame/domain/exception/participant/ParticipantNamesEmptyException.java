package laddergame.domain.exception.participant;

public class ParticipantNamesEmptyException extends IllegalArgumentException {
    private static final String PARTICIPANTS = "[ERROR] 참가자 이름은 비어있을 수 없습니다.";

    public ParticipantNamesEmptyException() {
        super(PARTICIPANTS);
    }
}
