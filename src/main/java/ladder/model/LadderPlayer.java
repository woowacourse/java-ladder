package ladder.model;

import ladder.validator.LadderPlayerValidator;

import java.util.Objects;

public class LadderPlayer {
    public static final int MAX_LENGTH_OF_NAME = 5;
    private static final String FORMAT_OF_ALIGNED_NAME = "%-" + MAX_LENGTH_OF_NAME + "s";
    private static final String BLANK_FOR_ALIGNMENT_ON_LADDER = " ";
    private final String name;

    public LadderPlayer(final String name) {
        LadderPlayerValidator.checkAccuracyOfName(name);
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    String getAlignedName() {
        return String.format(FORMAT_OF_ALIGNED_NAME, name) + BLANK_FOR_ALIGNMENT_ON_LADDER;
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
