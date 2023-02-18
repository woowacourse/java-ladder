package laddergame.domain.rung;

import java.util.Objects;

public class Rung {

    protected static final boolean INSUFFICIENT = false;

    private final boolean existence;

    private Rung(final boolean material) {
        this.existence = material;
    }

    public static Rung create(final boolean material) {
        return new Rung(material);
    }

    public boolean isExistence() {
        return existence;
    }

    @Override
    public boolean equals(final Object diffRung) {
        if (this == diffRung) {
            return true;
        }
        if (diffRung == null || getClass() != diffRung.getClass()) {
            return false;
        }
        Rung rung = (Rung) diffRung;
        return existence == rung.existence;
    }

    @Override
    public int hashCode() {
        return Objects.hash(existence);
    }
}
