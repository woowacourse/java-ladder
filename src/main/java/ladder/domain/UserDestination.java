package ladder.domain;

public class UserDestination {
    private final UserName userName;
    private final Destination destination;

    public UserDestination(UserName userName, Destination destination) {
        this.userName = userName;
        this.destination = destination;
    }

    public boolean isSameName(final String name) {
        return userName.isSame(name);
    }

    public UserName getUserName() {
        return userName;
    }

    public Destination getDestination() {
        return destination;
    }
}
