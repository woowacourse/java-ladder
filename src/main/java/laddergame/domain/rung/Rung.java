package laddergame.domain.rung;

public class Rung {

    private static final int SUFFICIENT = 1;
    private static final int INSUFFICIENT = 0;
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
}
