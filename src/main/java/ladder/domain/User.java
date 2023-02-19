package ladder.domain;

public class User {

    private static final int INIT_Y_POSITION = 0;

    private final UserName userName;
    private int xPosition;
    private int yPosition;

    public User(String name) {
        this.userName = new UserName(name);
        this.yPosition = INIT_Y_POSITION;
    }

    public User(String name, int x) {
        this(name);
        this.xPosition = x;
    }

    public String getName() {
        return userName.getName();
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
}
