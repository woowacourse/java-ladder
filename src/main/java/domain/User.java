package domain;

import utils.validator.Validator;

public class User {
    private final String name;

    public User(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isEqualName(String userName) {
        return userName.equals(name);
    }
}
