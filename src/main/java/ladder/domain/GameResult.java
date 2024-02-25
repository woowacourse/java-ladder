package ladder.domain;

public class GameResult {
    private final UserName userName;
    private final Destination destination;

    public GameResult(UserName userName, Destination destination) {
        this.userName = userName;
        this.destination = destination;
    }

    public UserName getUserName() {
        return userName;
    }

    public Destination getDestination() {
        return destination;
    }
}
