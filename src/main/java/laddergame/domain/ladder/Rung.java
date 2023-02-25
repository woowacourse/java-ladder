package laddergame.domain.ladder;

import java.util.Objects;

public class Rung {

    private final boolean exists;

    private Rung(final boolean canMakeRung) {
        this.exists = canMakeRung;
    }

    public static Rung create(final boolean canMakeRung) {
        return new Rung(canMakeRung);
    }

    public boolean exists() {
        return exists;
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
        return exists == rung.exists;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exists);
    }
}
