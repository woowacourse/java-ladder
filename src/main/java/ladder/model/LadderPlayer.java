package ladder.model;

import ladder.validator.PlayerValidator;

public class LadderPlayer {

    private static final String STANDARD_FORMAT_FIRST_INDEX = "%-";
    private static final String STANDARD_FORMAT_SECOND_INDEX = "s";

    private String name;

    public LadderPlayer(String name) {
        this.name = PlayerValidator.validatedName(name);
    }

    public String getName() {
        return name;
    }

    public String getAlignedName(int maxLenOfGoalNames) {
        return String.format(STANDARD_FORMAT_FIRST_INDEX + (maxLenOfGoalNames + 1) + STANDARD_FORMAT_SECOND_INDEX, name);
    }
}
