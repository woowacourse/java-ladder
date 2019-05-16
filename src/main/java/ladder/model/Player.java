package ladder.model;

import ladder.validator.PlayerValidator;

public class Player {

    private static final String STANDARD_FORMAT = "%-6s";
    private String name;

    public Player(String name) {
        this.name = PlayerValidator.validatedName(name);
    }

    public String getName() {
        return name;
    }

    public String getAlignedName() {
        return String.format(STANDARD_FORMAT, name);
    }
}
