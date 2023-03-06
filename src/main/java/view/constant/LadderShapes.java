package view.constant;

public enum LadderShapes {
    PILLAR("|"),
    FOOTSTEP("-"),
    BLANK(" ");

    private final String shape;

    LadderShapes(final String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
