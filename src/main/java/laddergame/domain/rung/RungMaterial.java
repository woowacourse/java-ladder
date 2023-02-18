package laddergame.domain.rung;

public enum RungMaterial {
    SUFFICIENT(true),
    INSUFFICIENT(false);

    private final boolean material;

    RungMaterial(final boolean material) {
        this.material = material;
    }

    public boolean getMaterial() {
        return material;
    }
}
