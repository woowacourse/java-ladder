package laddergame.domain;

import laddergame.util.Validator;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Player(String name) {
        Validator.checkBlankName(name);
        Validator.checkNameLength(name, MAX_NAME_LENGTH);
        this.name = name;
    }
}
