package laddergame.domain.gameelements.people;

import laddergame.domain.gameelements.Element;

public class Name extends Element {
    public Name(String playerName) {
        super(playerName);
    }

    public String getName() {
        return super.getElement();
    }
}
