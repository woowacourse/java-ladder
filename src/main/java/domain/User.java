package domain;

import utils.Validator;

public class User {

    private final String name;

    public User(final String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
