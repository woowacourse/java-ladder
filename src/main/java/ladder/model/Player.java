package ladder.model;

import ladder.validator.PlayerValidator;

public class Player {
    private String name;

    public Player(String name) {
        this.name = PlayerValidator.validatedName(name);
    }

    public String getName() {
        return name;
    }

}
