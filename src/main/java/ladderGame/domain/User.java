package ladderGame.domain;

import java.util.*;

public class User {

    private final UserName name;
    private int position;

    public User(final String name, final int lineNum) {
        this.name = new UserName(name);
        this.position = lineNum;
    }

    public int movePosition(int distance) {
        this.position += distance;
        return position;
    }

    public UserName getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return position == user.position &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
