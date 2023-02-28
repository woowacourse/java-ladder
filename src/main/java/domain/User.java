package domain;

import java.util.List;

public class User {

    private static final int NOT_FOUND_CONNECTION = -1;

    private final Name name;
    private final Position position;

    private User(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static User of(Name name, Position position) {
        return new User(name, position);
    }

    public void movePosition(List<Integer> numbers) {
        int number = position.findConnectionNumber(numbers);

        if (number != NOT_FOUND_CONNECTION) {
            position.move(number);
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

}
