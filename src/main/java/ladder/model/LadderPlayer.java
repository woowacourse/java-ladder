package ladder.model;

import ladder.validator.PlayerValidator;

public class LadderPlayer {

    private static final String STANDARD_FORMAT = "%-6s";
    private String name;

    public LadderPlayer(String name) {
        this.name = PlayerValidator.validatedName(name);
    }

    public String getName() {
        return name;
    }

    public String getAlignedName() {
        return String.format(STANDARD_FORMAT, name);
    }
}
