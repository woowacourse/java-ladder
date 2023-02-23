package laddergame.domain.request;

import laddergame.domain.participant.Participants;

public class Request {

    public static final String ALL_PARTICIPANTS_REQUEST_KEY = "all";
    private final String requestContent;

    public Request(final String requestContent, Participants participants) {
        validateRequestExistence(requestContent, participants);
        this.requestContent = requestContent;
    }

    private void validateRequestExistence(final String requestContent, final Participants participants) {
        if (!requestContent.equals(ALL_PARTICIPANTS_REQUEST_KEY) || !participants.contains(requestContent)) {
            throw new IllegalArgumentException(String.format("[ERROR] %s은 존재하지 않는 이름입니다. 참여자 한 명의 이름 혹은 \"all\"을 입력하세요.", requestContent));
        }
    }
}
