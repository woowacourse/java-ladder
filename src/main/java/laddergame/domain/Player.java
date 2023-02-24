package laddergame.domain;

import laddergame.vo.LadderLabel;

public class Player {

    private final LadderLabel name;

    public Player(String name) {
        this.name = new LadderLabel(name);
    }

    public String getName() {
        return name.getValue();
    }
}
