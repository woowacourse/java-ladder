package laddergame.domain.gameelements.people;

import laddergame.domain.gameelements.Element;

public class Name extends Element {
    private final String name;

    public Name(String name) {
        super(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
