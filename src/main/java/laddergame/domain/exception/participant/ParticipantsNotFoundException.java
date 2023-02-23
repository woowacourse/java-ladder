package laddergame.domain.exception.participant;

public class ParticipantsNotFoundException extends IllegalArgumentException {

    private static final String PARTICIPANTS = "[ERROR] 존재하지 않는 값입니다. 현재 참여자 리스트 = %s";

    public ParticipantsNotFoundException(final String data) {
        super(String.format(PARTICIPANTS, data));
    }
}
