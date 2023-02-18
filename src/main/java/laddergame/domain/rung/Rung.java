package laddergame.domain.rung;

import java.util.Objects;

import static laddergame.domain.message.ErrorMessage.INVALID_MATERIAL;

public class Rung {

    protected static final int SUFFICIENT = 1;
    protected static final int INSUFFICIENT = 0;

    private final boolean exists;

    private Rung(final int material) {
        validateMaterial(material);
        this.exists = makeRung(material);
    }

    public static Rung create(final int material) {
        return new Rung(material);
    }

    public boolean exists() {
        return exists;
    }

    private void validateMaterial(final int material) {
        if (material != SUFFICIENT && material != INSUFFICIENT) {
            throw new IllegalArgumentException(INVALID_MATERIAL.getMessage());
        }
    }

    private boolean makeRung(final int material) {
        return material == SUFFICIENT;
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
