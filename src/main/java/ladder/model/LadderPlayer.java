package ladder.model;

import ladder.MessageCollection;

import java.util.Objects;

public class LadderPlayer {

    private static final String STANDARD_FORMAT_FIRST_INDEX = "%-";
    private static final String STANDARD_FORMAT_SECOND_INDEX = "s";
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public LadderPlayer(String name) {
        this.name = validatedName(name);
    }

    private String validatedName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(MessageCollection.ERROR_HAS_VALUE_EMPTY);
        }
        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MessageCollection.ERROR_OVER_LENGTH);
        }
        return name.trim();
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
