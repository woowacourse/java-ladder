package domain;

import utils.validator.NameValidator;

public class Name {

    private final String name;

    public Name(String name) {
        NameValidator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
