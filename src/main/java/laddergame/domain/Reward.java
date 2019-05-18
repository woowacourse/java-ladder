package laddergame.domain;

import laddergame.util.Validator;

public class Reward {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Reward(String name) {
        Validator.checkBlankName(name);
        Validator.checkNameLength(name, MAX_NAME_LENGTH);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
