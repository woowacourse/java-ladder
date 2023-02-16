package domain;

import domain.validator.PlayerNameValidator;

public class PlayerName {

    private final String name;

    public PlayerName(final String name) {
        PlayerNameValidator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
