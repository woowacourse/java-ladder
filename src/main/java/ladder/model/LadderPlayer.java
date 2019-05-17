package ladder.model;

import ladder.validator.PlayerValidator;

import java.util.Objects;

public class LadderPlayer {

    private static final String STANDARD_FORMAT_FIRST_INDEX = "%-";
    private static final String STANDARD_FORMAT_SECOND_INDEX = "s";

    private String name;

    public LadderPlayer(String name) {
        this.name = PlayerValidator.validatedName(name);
    }

    public String getPlayerName() {
        return name;
    }

    public String getAlignedName(int maxLenOfGoalNames) {
        return String.format(STANDARD_FORMAT_FIRST_INDEX + (maxLenOfGoalNames + 1) + STANDARD_FORMAT_SECOND_INDEX, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderPlayer that = (LadderPlayer) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
