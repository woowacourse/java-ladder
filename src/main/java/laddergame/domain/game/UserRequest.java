package laddergame.domain.game;

public class UserRequest {

    public static final String ALL_PLAYER_COMMAND = "all";
    private static final UserRequest ALL_PLAYER = new UserRequest(ALL_PLAYER_COMMAND);
    private final String requestContent;

    private UserRequest(final String requestContent) {
        this.requestContent = requestContent;
    }

    public static UserRequest of(final String requestContent) {
        if (requestContent.equals(ALL_PLAYER_COMMAND)) {
            return ALL_PLAYER;
        }
        return new UserRequest(requestContent);
    }

    public boolean isAllPlayer() {
        return this.equals(ALL_PLAYER);
    }

    public String getRequestContent() {
        return requestContent;
    }
}
