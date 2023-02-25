package laddergame.domain.game;

public class UserRequest {

    public static final String ALL_PARTICIPANTS_COMMAND = "all";
    private static final UserRequest ALL_PARTICIPANTS = new UserRequest(ALL_PARTICIPANTS_COMMAND);
    private final String requestContent;

    private UserRequest(final String requestContent) {
        this.requestContent = requestContent;
    }

    public static UserRequest of(final String requestContent) {
        if (requestContent.equals(ALL_PARTICIPANTS_COMMAND)) {
            return ALL_PARTICIPANTS;
        }
        return new UserRequest(requestContent);
    }

    public boolean isAllParticipants() {
        return this.equals(ALL_PARTICIPANTS);
    }

    public String getRequestContent() {
        return requestContent;
    }
}
