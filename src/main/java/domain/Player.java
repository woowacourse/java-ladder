package domain;

import static message.ErrorMessage.*;

import java.util.regex.Pattern;
import message.ErrorMessage;

public class Player {

    private final Name name;

    public Player(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }
}
