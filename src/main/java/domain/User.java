package domain;

import java.util.List;

public class User {
    private final Name name;
    private final Position position;

    public User(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void movePosition(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (position.checkConnection(number)) {
                position.move(number);
                break;
            }
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
