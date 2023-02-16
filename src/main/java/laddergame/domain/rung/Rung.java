package laddergame.domain.rung;

import java.util.Objects;

import static laddergame.domain.message.ErrorMessage.INVALID_MATERIAL;

public class Rung {

    protected static final int SUFFICIENT = 1;
    protected static final int INSUFFICIENT = 0;
    private final boolean existence;

    private Rung(final int material) {
        validateMaterial(material);
        this.existence = makeRung(material);
    }

    public static Rung create(final int material) {
        return new Rung(material);
    }

    public boolean isExistence() {
        return existence;
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
        return existence == rung.existence;
    }

    @Override
    public int hashCode() {
        return Objects.hash(existence);
    }
}
