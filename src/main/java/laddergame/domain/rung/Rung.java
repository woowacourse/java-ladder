package laddergame.domain.rung;

import java.util.Objects;

public class Rung {

    protected static final int SUFFICIENT = 1;
    protected static final int INSUFFICIENT = 0;
    private final boolean existence;

    public Rung(final int material) {
        if (material != SUFFICIENT && material != INSUFFICIENT) {
            throw new IllegalArgumentException("[ERROR] 잘못된 사다리 가로대 인자입니다.");
        }
        this.existence = makeRung(material);
    }

    private boolean makeRung(final int material) {
        return material == SUFFICIENT;
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
