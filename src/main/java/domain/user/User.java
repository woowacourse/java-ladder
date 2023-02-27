package domain.user;

public class User {
    private final Name name;
    private final Position position;

    public User(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}
