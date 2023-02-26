package domain;

import java.util.Objects;

import domain.validator.Validator;

public class User {
    private final String name;

    public User(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return this.name.equals(user.name);
    }

    public String getName() {
        return name;
    }
}
