package model;

import java.util.Collections;
import java.util.List;

public class Player {
    private final Name name;

    public Player(final String name){
        this.name = new Name(name);
    }

    public String getPlayer() {
        return name.getName();
    }
}
