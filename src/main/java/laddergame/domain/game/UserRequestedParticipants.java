package laddergame.domain.game;

public class UserRequestedParticipants {

    public static final String ALL_PARTICIPANTS_COMMAND = "all";
    private static final UserRequestedParticipants ALL_PARTICIPANTS = new UserRequestedParticipants(ALL_PARTICIPANTS_COMMAND);

    private final String requestContent;

    private UserRequestedParticipants(final String requestContent) {
        this.requestContent = requestContent;
    }

    public static UserRequestedParticipants from(final String requestContent) {
        if (requestContent.equals(ALL_PARTICIPANTS_COMMAND)) {
            return ALL_PARTICIPANTS;
        }
        return new UserRequestedParticipants(requestContent);
    }

    public boolean isAllParticipants() {
        return this.equals(ALL_PARTICIPANTS);
    }

    public String getRequestContent() {
        return requestContent;
    }
}
