package domain;

import domain.validator.PlayerNameValidator;

public class PlayerName {
    private final String name;

    public PlayerName(String name) {
        PlayerNameValidator playerNameValidator = new PlayerNameValidator();
        playerNameValidator.checkPlayerName(name);
        this.name = name;
    }

    public int getNameSize() {
        return name.length();
    }

    public String getName() {
        return name;
    }
}
