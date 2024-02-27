package model;

import exception.Message;
import java.util.Objects;
import java.util.regex.Pattern;

public class Player {

    private static final Pattern NAME_SPECIFICATION = Pattern.compile("^[A-Za-z]+$");
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(final String name) {
        validate(name.trim());
        this.name = name.trim();
    }

    private void validate(final String name) {
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
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Player player)) {
            return false;
        }
        return Objects.equals(name, player.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
