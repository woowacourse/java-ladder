package laddergame.domain.exception.participant;

public class ParticipantCountLowerException extends IllegalArgumentException {
    private static final String INVALID_PARTICIPANT_COUNT = "[ERROR] 참가자 이름은 최소 %d명 이상 입력해야 합니다.";

    public ParticipantCountLowerException(final int minCount) {
        super(String.format(INVALID_PARTICIPANT_COUNT, minCount));
    }
}
