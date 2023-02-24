package ladder.domain;

public class User {

    private final UserName userName;

    public User(String name) {
        this.userName = new UserName(name);
    }

    public UserName getName() {
        return userName;
    }
}
