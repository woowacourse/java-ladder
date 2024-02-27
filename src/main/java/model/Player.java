package model;

import exception.Message;
import java.util.regex.Pattern;

public class Player {

    private static final Pattern NAME_SPECIFICATION = Pattern.compile("^[A-Za-z]+$");
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Message.INVALID_PLAYER_ERROR.getValue());
        }
        if (!NAME_SPECIFICATION.matcher(name).matches()) {
            throw new IllegalArgumentException(Message.INVALID_PLAYER_ERROR.getValue());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
