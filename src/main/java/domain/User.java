package domain;

import utils.constants.Validator;

public class User {
    private final String name;

    public User(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
